package com.haz.util.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 通用服务异常类
 * 
 * @author aizhou.huang
 * @date 2018年7月30日
 */
@Setter
@Getter
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private ServiceExceptionEnum exceptionEnum;

	private String message;

	/**
	 * 使用调用响应代码包装异常
	 *
	 * @param code
	 */
	public ServiceException(ServiceExceptionEnum exceptionEnum) {
		super(exceptionEnum.name());
		this.exceptionEnum = exceptionEnum;
	}

	public ServiceException(String message) {
		super(message);
		this.message = message;
	}
}