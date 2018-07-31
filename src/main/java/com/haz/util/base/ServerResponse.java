package com.haz.util.base;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.haz.util.exception.ServiceExceptionEnum;

import lombok.Getter;
import lombok.Setter;

/**
 * 公共服务端响应对象
 */
@Getter
@Setter
public class ServerResponse<T> implements Serializable {

	private static final long serialVersionUID = -7704946167533228901L;

	private String resultCode;// 状态

	private String resultDesc;// 消息

	private T data;// 数据对象

	public ServerResponse() {
		super();
	}

	private ServerResponse(String resultCode, String resultDesc, T data) {
		this.resultCode = resultCode;
		this.resultDesc = resultDesc;
		this.data = data;
	}

	private ServerResponse(String resultCode, String resultDesc) {
		this.resultCode = resultCode;
		this.resultDesc = resultDesc;
	}

	public boolean isSuccess() {
		return StringUtils.equals(this.resultCode, ServiceExceptionEnum.SUCCESS.getCode());
	}

	/*********************** 响应成功 *******************************/
	public static <T> ServerResponse<T> createBySuccess() {
		return new ServerResponse<T>(ServiceExceptionEnum.SUCCESS.getCode(), ServiceExceptionEnum.SUCCESS.getMessage());
	}

	public static <T> ServerResponse<T> createBySuccess(T data) {
		return new ServerResponse<T>(ServiceExceptionEnum.SUCCESS.getCode(), ServiceExceptionEnum.SUCCESS.getMessage(),
				data);
	}

	public static <T> ServerResponse<T> createBySuccess(String resultDesc, T data) {
		return new ServerResponse<T>(ServiceExceptionEnum.SUCCESS.getCode(), resultDesc, data);
	}

	public static <T> ServerResponse<T> createBySuccessMessage(String resultDesc) {
		return new ServerResponse<T>(ServiceExceptionEnum.SUCCESS.getCode(), resultDesc);
	}

	/*********************** 响应失败 *******************************/
	public static <T> ServerResponse<T> createByError() {
		return new ServerResponse<T>(ServiceExceptionEnum.SYSTEM_ERROR.getCode(),
				ServiceExceptionEnum.SYSTEM_ERROR.getMessage());
	}

	public static <T> ServerResponse<T> createByErrorMessage(String errorMessage) {
		return new ServerResponse<T>(ServiceExceptionEnum.SYSTEM_ERROR.getCode(), errorMessage);
	}

	public static <T> ServerResponse<T> createByErrorCodeMessage(String errorCode, String errorMessage) {
		return new ServerResponse<T>(errorCode, errorMessage);
	}

}
