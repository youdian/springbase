package org.youdian.springbase.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.youdian.springbase.mapper.LocationMapper;
import org.youdian.springbase.model.GeoLocation;
import org.youdian.springbase.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {
	//搜索范围限定到附近500英里内
	private static final double distance = 500;
	@Autowired
	LocationMapper locationMapper;
	
	@Override
	public void insertLocation(GeoLocation location) {
		locationMapper.insertLocation(location);

	}

	@Override
	public List<GeoLocation> findNearbyLocations(GeoLocation location) {
		return locationMapper.findNearbyLocations(location.getLatitude(), location.getLongtitude(), distance);
	}

}
