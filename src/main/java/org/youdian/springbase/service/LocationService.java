package org.youdian.springbase.service;

import java.util.List;

import org.youdian.springbase.model.GeoLocation;

public interface LocationService {

	public void insertLocation(GeoLocation location);
	public List<GeoLocation> findNearbyLocations(GeoLocation location);
}
