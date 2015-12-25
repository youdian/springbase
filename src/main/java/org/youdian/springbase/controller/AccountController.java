package org.youdian.springbase.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.youdian.springbase.model.User;
import org.youdian.springbase.util.ResponseEntityUtil;

//处理用户注册，登录相关
@RestController
@RequestMapping("/account")
public class AccountController extends BaseController {
	
	public enum LoginType {
		PHONE(0),
		WEiXin(1),
		WEIBO(2),
		QQ(3);
		
		private int value;
		LoginType(int value) {
			this.value = value;
		}
		
		public int intValue() {
			return value;
		}
	}
	
	@ResponseBody
	@RequestMapping("register")
	public ResponseEntity<?> register(@RequestBody User user) {
		return ResponseEntityUtil.entityWithStatusCode(HttpStatus.OK);
	}
}
