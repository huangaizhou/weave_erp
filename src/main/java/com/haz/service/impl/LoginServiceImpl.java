package com.haz.service.impl;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.haz.bean.UserBean;
import com.haz.pojo.UserPojo;
import com.haz.service.LoginService;
import com.haz.service.RedisService;
import com.haz.service.UserService;
import com.haz.util.AssertionUtil;
import com.haz.util.exception.ServiceExceptionEnum;

@Service
public class LoginServiceImpl implements LoginService {

	/**
	 * 验证码过期时间(单位秒)
	 */
	private static final int RANDOM_CODE_EXPIRE_TIME = 60;

	/**
	 * 用户过期时间(单位秒)
	 */
	private static final int USER_EXPIRE_TIME = 60 * 60;

	@Autowired
	private UserService userService;

	@Autowired
	private RedisService redisService;

	@Override
	public Map<String, Object> createToken(String text) {
		// 生成一个token
		String token = UUID.randomUUID().toString().replace("-", "");
		// token保存到redis
		redisService.setex(token, text, RANDOM_CODE_EXPIRE_TIME, TimeUnit.SECONDS);

		Map<String, Object> map = Maps.newHashMap();
		map.put("token", token);
		map.put("expire", RANDOM_CODE_EXPIRE_TIME);
		return map;
	}

	@Override
	public Integer login(UserBean userBean) {
		// 验证token
		String randomCode = redisService.get(userBean.getToken());
		AssertionUtil.isNotEmpty(randomCode, ServiceExceptionEnum.TOKEN_ERROR);
		// 比对验证码
		AssertionUtil.isTrue(StringUtils.equals(randomCode, userBean.getRandomCode()),
				ServiceExceptionEnum.RANDOM_CODE_ERROR);
		// 验证用户名
		UserPojo po = new UserPojo();
		po.setUserName(userBean.getUserName());
		po = userService.selectOne(po);
		AssertionUtil.isNotNull(po, ServiceExceptionEnum.USERNAME_NOT_EXIST);
		// 验证密码
		AssertionUtil.isTrue(StringUtils.equals(po.getPassword(), userBean.getPassword()),
				ServiceExceptionEnum.PASSWORD_ERROR);

		// 登录成功操作
		// 用户信息缓存进redis
		redisService.setex(String.format("%s-%s", po.getId(), userBean.getToken()), userBean.getUserName(),
				USER_EXPIRE_TIME, TimeUnit.SECONDS);

		return po.getId();
	}

}
