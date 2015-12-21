package org.youdian.springbase.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.youdian.springbase.util.ResponseEntityUtil;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> listPost() {
		return ResponseEntityUtil.entityWithSimpleResponse(0, "test response", HttpStatus.OK);
	}
}
