package com.haz.service;

import java.util.Map;

import com.haz.bean.UserBean;

public interface LoginService {

	/**
	 * 生成token
	 * 
	 * @param text
	 * @return
	 */
	Map<String, Object> createToken(String text);

	/**
	 * 用户登录
	 * 
	 * @param userBean
	 * @return
	 */
	Integer login(UserBean userBean);

}
