package com.haz.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RolePojo {
	private Integer id;

	private String roleCode;

	private String roleName;

	private String state;

	private Date createTime;

	private Date updateTime;

}