package com.haz.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author aizhou.huang
 * @date 2018年7月31日
 */
public interface RedisService {

	/**
	 *
	 * @param key
	 * @param value
	 */
	void set(String key, String value);

	/**
	 *
	 * @param key
	 * @return
	 */
	String get(String key);

	/**
	 *
	 * @param key
	 */
	void delete(String key);

	/**
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	boolean setnx(String key, String value);

	/**
	 * 设置有有效期的key
	 * 
	 * @param key
	 * @param value
	 * @param timeout
	 * @param timeUnit
	 *            单位 TimeUnit.DAYS //天 TimeUnit.HOURS //小时 TimeUnit.MINUTES //分钟
	 *            TimeUnit.SECONDS //秒 TimeUnit.MILLISECONDS //毫秒
	 */
	void setex(String key, String value, long timeout, TimeUnit timeUnit);

	/**
	 * 设置键的字符串值并返回其旧值
	 * 
	 * @param key
	 * @param newValue
	 * @return
	 */
	String getAndSet(String key, String newValue);

	/**
	 * 为多个键分别设置它们的值
	 * 
	 * @param map
	 */
	void multiSet(Map<String, String> map);

	/**
	 * 为多个键分别取出它们的值
	 * 
	 * @param keyList
	 * @return
	 */
	List<String> multiGet(List<String> keyList);

	/**
	 * 支持整数
	 * 
	 * @param key
	 * @param delta
	 */
	void increment(String key, long delta);

	/**
	 * 将所有指定的值插入存储在键的列表的头部。 如果键不存在，则在执行推送操作之前将其创建为空列表。（从右边插入）
	 * 
	 * @param key
	 * @param listStr
	 */
	void rightPush(String key, String listStr);

	/**
	 *
	 * @param key
	 * @param stringarrays
	 */
	void rightPushAllArrays(String key, String[] stringarrays);

	/**
	 *
	 * @param key
	 * @param StringList
	 */
	void rightPushAllList(String key, List<String> StringList);

	/**
	 * 弹出最左边的元素，弹出之后该值在列表中将不复存在
	 * 
	 * @param key
	 * @return
	 */
	String leftPop(String key);

	/**
	 * 返回存储在键中的列表的长度。如果键不存在，则将其解释为空列表，并返回0。 当key存储的值不是列表时返回错误。
	 * 
	 * @param key
	 * @return
	 */
	Long listLength(String key);

	/**
	 * 设置散列hashKey的值
	 * 
	 * @param key
	 * @param hashKey
	 * @param hashValue
	 */
	void put(String key, String hashKey, String hashValue);

	/**
	 *
	 * @param key
	 * @param map
	 */
	void putAll(String key, Map<String, String> map);

	/**
	 * 仅当hashKey不存在时才设置散列hashKey的值。
	 * 
	 * @param key
	 * @param hashKey
	 * @param hashValue
	 */
	void putnx(String key, String hashKey, String hashValue);

	/**
	 * 从键中的哈希获取给定hashKey的值
	 * 
	 * @param key
	 * @param hashKey
	 * @return
	 */
	String getMapValue(String key, String hashKey);

	/**
	 * 删除给定的哈希hashKeys
	 * 
	 * @param key
	 * @param hashKeys
	 */
	void delMap(String key, String hashKeys);

	/**
	 * 无序集合中添加元素，返回添加个数
	 * 
	 * @param key
	 * @param stringarrays
	 */
	void add(String key, String[] stringarrays);

	/**
	 * 移除并返回集合中的一个随机元素
	 * 
	 * @param key
	 * @return
	 */
	String pop(String key);

	Map<Object, Object> getMap(String key);

	/**
	 * 给key设置有效期
	 * 
	 * @param key
	 * @param exTime
	 */
	void expire(String key, long exTime);
}
