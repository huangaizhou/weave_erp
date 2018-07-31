package com.haz.util.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 通用service
 * 
 * @author aizhou.huang
 *
 * @param <T>
 */
public class BaseService<T> implements IBaseService<T> {

	@Autowired
	protected BaseMapper<T> mapper;

	public BaseMapper<T> getMapper() {
		return mapper;
	}

	@Override
	public T selectByKey(Object key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<T> select(T entity) {
		return mapper.select(entity);
	}

	@Override
	public T selectOne(T entity) {
		return mapper.selectOne(entity);
	}

	@Override
	public int selectCount(T entity) {
		return mapper.selectCount(entity);
	}

	@Override
	public int save(T entity) {
		return mapper.insert(entity);
	}

	@Override
	public int save(List<T> list) {
		return mapper.insertList(list);
	}

	@Override
	public int delete(T entity) {
		return mapper.delete(entity);
	}

	@Override
	public int deleteByKey(Object key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int updateSelective(T entity) {
		return mapper.updateByPrimaryKeySelective(entity);
	}

}
