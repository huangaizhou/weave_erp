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

	private String token;// 令牌

}