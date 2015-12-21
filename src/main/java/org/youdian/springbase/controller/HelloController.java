package org.youdian.springbase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.youdian.springbase.model.User;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@ResponseBody
	@RequestMapping("/hello.do")
	public User sayHello() {
		User user = new User();
		user.setUid(1);
		user.setName("xiaoming");
		return user;
	}
}
