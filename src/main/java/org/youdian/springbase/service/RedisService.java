package org.youdian.springbase.service;

public interface RedisService {

	public int getUserId(String key);
	public void setUserId(String key, String id); 
}
