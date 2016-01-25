package org.youdian.springbase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.youdian.springbase.model.GeoLocation;
import org.youdian.springbase.model.SimpleResponse;
import org.youdian.springbase.service.LocationService;
import org.youdian.springbase.util.ResponseEntityUtil;

@RestController
@RequestMapping("/location")
public class LocationController {
	
	@Autowired
	LocationService locationService;
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<SimpleResponse> insertLocation(@RequestBody GeoLocation location) {
		System.out.println(location.toString());
		locationService.insertLocation(location);
		return ResponseEntityUtil.entityWithSimpleResponse(200, "success", HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public ResponseEntity<?> findNearbyLocations(@RequestBody GeoLocation location) {
		System.out.println(location.toString());
		List<GeoLocation> locations = locationService.findNearbyLocations(location);
		return ResponseEntityUtil.entityWithData(locations, HttpStatus.OK);
	}
}
