package com.haz.service;

import java.util.Map;

public interface LoginService {

	/**
	 * 生成token
	 * 
	 * @param text
	 * @return
	 */
	Map<String, Object> createToken(String text);

}
