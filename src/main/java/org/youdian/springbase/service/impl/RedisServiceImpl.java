package org.youdian.springbase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.youdian.springbase.model.User;
import org.youdian.springbase.service.RedisService;

@Service
public class RedisServiceImpl implements RedisService{
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	@Override
	public int getUserId(String key) {
		String value = redisTemplate.opsForValue().get(key);
		System.out.println("read from redis, key=" + key + ", value=" + value);
		if (value == null || value.equals("")) {
			return User.INVALID_USER_ID;
		}
		return Integer.valueOf(value);
	}

	@Override
	public void setUserId(String key, String id) {
		System.out.println("put in redis key=" + key + ", value=" + id);
		redisTemplate.opsForValue().set(key, id);
	}

}
