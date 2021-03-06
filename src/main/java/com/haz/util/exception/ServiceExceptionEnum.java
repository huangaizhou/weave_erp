package com.haz.util.exception;

/**
 * 响应状态码
 * 
 * @author aizhou.huang
 * @date 2018年7月30日
 */
public enum ServiceExceptionEnum {

	/**
	 * 通用异常
	 */
	SUCCESS("0000", "成功,系统处理正常"),
	PARAM_ERROR("0001","参数异常"),
	TOKEN_ERROR("0002","令牌不存在或已过期"), 
	RANDOM_CODE_ERROR("0003","验证码不正确"), 
	USERNAME_NOT_EXIST("0004","用户名不存在"),
	PASSWORD_ERROR("0005","密码错误"), 
	ACCOUNT_DISABLE("0006","账号已被禁用"), 
	SYSTEM_ERROR("9999", "系统异常"), 
	;

	private String code;

	private String message;

	private ServiceExceptionEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}