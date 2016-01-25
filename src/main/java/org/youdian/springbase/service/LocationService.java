package org.youdian.springbase.service;

import java.util.List;

import org.youdian.springbase.model.GeoLocation;

/**
 * 位置服务操作
 * @author zhouzhou
 *
 */
public interface LocationService {
	//搜索范围限定到附近500英里内
	static final double distance = 500;
	/**
	 * 插入一条位置记录
	 * @param location
	 */
	public void insertLocation(GeoLocation location);
	/**
	 * 查看位置附近一定距离内的所有记录
	 * @param location
	 * @return
	 */
	public List<GeoLocation> findNearbyLocations(GeoLocation location);
}
