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

	private String code;

	private String message;

	/**
	 * 使用调用响应代码包装异常
	 *
	 * @param code
	 */
	public ServiceException(ServiceExceptionEnum exceptionEnum) {
		this.code = exceptionEnum.getCode();
		this.message = exceptionEnum.getMessage();
	}

	public ServiceException(String message) {
		this.code = ServiceExceptionEnum.SYSTEM_ERROR.getCode();
		this.message = message;
	}

}