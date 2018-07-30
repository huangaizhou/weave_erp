package com.haz.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourcePojo {
	private Integer id;

	private String resourceCode;

	private String resourceName;

	private String resourceType;

	private Integer parentId;

	private Integer orders;

	private String state;

	private Date createTime;

	private Date updateTime;

}