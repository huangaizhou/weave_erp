package com.haz.bean;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceBean {
	private Integer id;
	/**
	 * 资源代码
	 */
	private String resourceCode;

	/**
	 * 资源名称
	 */
	private String resourceName;

	/**
	 * 资源类型（1：菜单，2：按钮）
	 */
	private String resourceType;

	/**
	 * 上级资源id,如果该资源无上级默认为0
	 */
	private Integer parentId;

	/**
	 * 排序字段，用于调整资源显示位置
	 */
	private Integer orders;

	/**
	 * 状态（0 无效， 1 正常）
	 */
	private String state;

	private Date createTime;

	private Date updateTime;

}
