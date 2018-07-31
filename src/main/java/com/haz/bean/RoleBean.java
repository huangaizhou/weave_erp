package com.haz.bean;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleBean {
	private Integer id;

	/**
	 * 角色名称
	 */
	private String roleName;

	/**
	 * 状态（0 停用， 1 正常）
	 */
	private String state;

	private Date createTime;

	private Date updateTime;
}
