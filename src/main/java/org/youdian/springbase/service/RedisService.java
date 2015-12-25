package org.youdian.springbase.service;

public interface RedisService {

	public String getValue(String key);
	public void putValue(String key, String value); 
}
