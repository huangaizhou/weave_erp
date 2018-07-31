package com.haz.util.base;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName BaseRequest
 * @Description 请求基类
 */
@Setter
@Getter
public abstract class BaseRequest {
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 令牌
	 */
	private String token;

}