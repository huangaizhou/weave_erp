package com.haz.service.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.haz.service.RedisService;

@Service
public class RedisServiceImpl implements RedisService {

	/*
	 * stringRedisTemplate.opsForValue();//操作字符串
	 * stringRedisTemplate.opsForHash();//操作hash
	 * stringRedisTemplate.opsForList();//操作list
	 * stringRedisTemplate.opsForSet();//操作set
	 * stringRedisTemplate.opsForZSet();//操作有序set
	 */

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Override
	public void set(String key, String value) {
		stringRedisTemplate.opsForValue().set(key, value);
	}

	public String get(String key) {
		return stringRedisTemplate.opsForValue().get(key);
	}

	public void delete(String key) {
		stringRedisTemplate.delete(key);
	}

	public boolean setnx(String key, String value) {
		return stringRedisTemplate.opsForValue().setIfAbsent(key, value);
	}

	public void setex(String key, String value, long timeout, TimeUnit timeUnit) {
		/*
		 * TimeUnit.DAYS //天 TimeUnit.HOURS //小时 TimeUnit.MINUTES //分钟
		 * TimeUnit.SECONDS //秒 TimeUnit.MILLISECONDS //毫秒
		 */
		stringRedisTemplate.opsForValue().set(key, value, timeout, timeUnit);
	}

	// 设置键的字符串值并返回其旧值
	public String getAndSet(String key, String newValue) {
		return stringRedisTemplate.opsForValue().getAndSet(key, newValue);
	}

	// 为多个键分别设置它们的值
	public void multiSet(Map<String, String> map) {
		stringRedisTemplate.opsForValue().multiSet(map);
	}

	// 为多个键分别取出它们的值
	public List<String> multiGet(List<String> keyList) {
		return stringRedisTemplate.opsForValue().multiGet(keyList);
	}

	// 支持整数
	public void increment(String key, long delta) {
		stringRedisTemplate.opsForValue().increment(key, delta);
	}

	// List
	// 将所有指定的值插入存储在键的列表的头部。如果键不存在，则在执行推送操作之前将其创建为空列表。（从右边插入）
	public void rightPush(String key, String listStr) {
		stringRedisTemplate.opsForList().rightPush(key, listStr);
	}

	public void rightPushAllArrays(String key, String[] stringarrays) {
		stringRedisTemplate.opsForList().rightPushAll(key, stringarrays);
	}

	public void rightPushAllList(String key, List<String> objectList) {
		stringRedisTemplate.opsForList().rightPushAll(key, objectList);
	}

	// 弹出最左边的元素，弹出之后该值在列表中将不复存在
	public String leftPop(String key) {
		return stringRedisTemplate.opsForList().leftPop(key);
	}

	// 返回存储在键中的列表的长度。如果键不存在，则将其解释为空列表，并返回0。当key存储的值不是列表时返回错误。
	public Long listLength(String key) {
		return stringRedisTemplate.opsForList().size(key);
	}

	// Map
	// 设置散列hashKey的值
	public void put(String key, String hashKey, String hashValue) {
		stringRedisTemplate.opsForHash().put(key, hashKey, hashValue);
	}

	public void putAll(String key, Map<String, String> map) {
		stringRedisTemplate.opsForHash().putAll(key, map);
	}

	// 仅当hashKey不存在时才设置散列hashKey的值。
	public void putnx(String key, String hashKey, String hashValue) {
		stringRedisTemplate.opsForHash().putIfAbsent(key, hashKey, hashValue);
	}

	// 从键中的哈希获取给定hashKey的值
	public String getMapValue(String key, String hashKey) {
		return stringRedisTemplate.opsForHash().get(key, hashKey).toString();
	}

	// 删除给定的哈希hashKeys
	public void delMap(String key, String hashKeys) {
		stringRedisTemplate.opsForHash().delete(key, hashKeys);
	}

	// set
	// 无序集合中添加元素，返回添加个数
	public void add(String key, String[] stringarrays) {
		stringRedisTemplate.opsForSet().add(key, stringarrays);
	}

	// 移除并返回集合中的一个随机元素
	public String pop(String key) {
		return stringRedisTemplate.opsForSet().pop(key);
	}

	public Map<Object, Object> getMap(String key) {
		return stringRedisTemplate.opsForHash().entries(key);
	}

	@Override
	public void expire(String key, long exTime) {
		stringRedisTemplate.expire(key, exTime, TimeUnit.SECONDS);
	}

}
