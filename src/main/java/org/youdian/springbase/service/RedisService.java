package org.youdian.springbase.service;

/**
 * 操作redis
 * @author zhouzhou
 *
 */
public interface RedisService {
	/**
	 * 根据key获取一个值
	 * @param key
	 * @return
	 */
	public String getValue(String key);
	/**
	 * 插入或者替换一条数据记录
	 * @param key
	 * @param value
	 */
	public void putValue(String key, String value); 
}
