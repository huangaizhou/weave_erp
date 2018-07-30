package com.haz.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserPojo {
	private Integer id;

	private String userName;

	private String password;

	private Integer roleId;

	private String state;

	private Date createTime;

	private Date updateTime;

}