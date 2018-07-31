package com.haz.util;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Pojo和Bean对象的转换类
 * 
 * @author aizhou.huang
 *
 * @param <Bean>
 * @param <Pojo>
 */
public abstract class ObjConverter<Bean, Pojo> {
	public abstract Bean from(Pojo from);

	public abstract Pojo to(Bean from);

	public List<Bean> from(List<Pojo> froms) {
		if (CollectionUtils.isEmpty(froms)) {
			return null;
		}
		List<Bean> list = new ArrayList<Bean>();
		for (Pojo from : froms) {
			list.add(from(from));
		}
		return list;
	}

	public List<Pojo> to(List<Bean> froms) {
		if (CollectionUtils.isEmpty(froms)) {
			return null;
		}
		List<Pojo> list = new ArrayList<Pojo>();
		for (Bean from : froms) {
			list.add(to(from));
		}
		return list;
	}

}
