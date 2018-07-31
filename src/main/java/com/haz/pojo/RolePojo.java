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
@Table(name = "sys_role")
public class RolePojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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