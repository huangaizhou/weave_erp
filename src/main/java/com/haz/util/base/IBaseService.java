package com.haz.util.base;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * 通用service接口
 * 
 * @author aizhou.huang
 *
 * @param <T>
 */
@Service
public interface IBaseService<T> {

	T selectByKey(Object key);

	List<T> select(T entity);

	T selectOne(T entity);
	
	int selectCount(T entity);

	int save(T entity);

	int save(List<T> list);

	int delete(T entity);

	int deleteByKey(Object key);

	int updateSelective(T entity);

}
