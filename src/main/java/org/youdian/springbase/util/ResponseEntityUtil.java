package org.youdian.springbase.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.youdian.springbase.model.SimpleResponse;

public class ResponseEntityUtil {

	public static ResponseEntity<?> entityWithStatusCode(HttpStatus status) {
		return new ResponseEntity<>(status);
	}
	
	public static ResponseEntity<SimpleResponse> entityWithSimpleResponse(int code, String desc, HttpStatus status) {
		return new ResponseEntity<SimpleResponse>(SimpleResponse.create(code, desc), status);
	}
	
	public static <Data> ResponseEntity<Data> entityWithData(Data data, HttpStatus status) {
		return new ResponseEntity<Data>(data, status);
	}
}
