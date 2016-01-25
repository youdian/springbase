package org.youdian.springbase.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.youdian.springbase.model.SimpleResponse;
/**
 * 生成ResponseEntity的工具类
 * @author zhouzhou
 *
 */
public class ResponseEntityUtil {
	
	/**
	 * 生成只包含http状态码的响应
	 * @param status
	 * @return
	 */
	public static ResponseEntity<?> entityWithStatusCode(HttpStatus status) {
		return new ResponseEntity<>(status);
	}
	
	/**
	 * 生成包含一个code和一个desc的响应
	 * @param code
	 * @param desc
	 * @param status
	 * @return
	 */
	public static ResponseEntity<SimpleResponse> entityWithSimpleResponse(int code, String desc, HttpStatus status) {
		return new ResponseEntity<SimpleResponse>(SimpleResponse.create(code, desc), status);
	}
	
	/**
	 * 生成包含数据的响应
	 * @param data
	 * @param status
	 * @return
	 */
	public static <Data> ResponseEntity<Data> entityWithData(Data data, HttpStatus status) {
		return new ResponseEntity<Data>(data, status);
	}
}
