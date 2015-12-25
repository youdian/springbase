package org.youdian.springbase.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.youdian.springbase.util.ResponseEntityUtil;

@ControllerAdvice
public class GlobalAdvice {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception ex) {
		ex.printStackTrace();
		System.out.println("exception in globalAdvice " + ex.toString());
		return ResponseEntityUtil.entityWithStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
