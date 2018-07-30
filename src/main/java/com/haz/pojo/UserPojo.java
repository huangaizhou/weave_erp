package com.haz.pojo;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "sys_user")
public class UserPojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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