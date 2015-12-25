package org.youdian.springbase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.youdian.springbase.service.RedisService;

@Service
public class RedisServiceImpl implements RedisService{
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	@Override
	public String getValue(String key) {
		String value = redisTemplate.opsForValue().get(key);
		System.out.println("read from redis, key=" + key + ", value=" + value);
		return value;
	}

	@Override
	public void putValue(String key, String value) {
		System.out.println("put in redis key=" + key + ", value=" + value);
		redisTemplate.opsForValue().set(key, value);
	}

}
