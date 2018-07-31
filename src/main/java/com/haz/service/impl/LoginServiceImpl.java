package com.haz.service.impl;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.haz.service.LoginService;
import com.haz.service.RedisService;

@Service
public class LoginServiceImpl implements LoginService {

	/**
	 * 验证码过期时间(单位秒)
	 */
	private static final int EXPIRE_TIME = 60;

	@Autowired
	private RedisService redisService;

	@Override
	public Map<String, Object> createToken(String text) {
		// 生成一个token
		String token = UUID.randomUUID().toString();
		// token保存到redis
		redisService.setex(token, text, EXPIRE_TIME, TimeUnit.SECONDS);

		Map<String, Object> map = Maps.newHashMap();
		map.put("token", token);
		map.put("expire", EXPIRE_TIME);
		return map;
	}

}
