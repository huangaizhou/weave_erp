package com.haz.bean;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserBean {
	private Integer id;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 角色id
	 */
	private Integer roleId;

	/**
	 * 账号状态（0 停用， 1 正常）
	 */
	private String state;

	private Date createTime;

	private Date updateTime;
}
