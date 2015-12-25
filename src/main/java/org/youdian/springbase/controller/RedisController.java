package org.youdian.springbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.youdian.springbase.service.RedisService;

@RestController
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	RedisService redisService;
	
	@RequestMapping(value="/{key}")
	public String get(@PathVariable String key) {
		return String.valueOf(redisService.getValue(key));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String set(@RequestParam String key, @RequestParam String value) {
		redisService.putValue(key, value);
		return "";
	}
}
