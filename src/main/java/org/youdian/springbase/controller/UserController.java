package org.youdian.springbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.youdian.springbase.model.User;
import org.youdian.springbase.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@ResponseBody
	@RequestMapping("/insert")
	public User insert() {
		User user = new User();
		user.setId(1);
		user.setName("xiaoming");
		userService.insertUser(user);
		return user;
	}
}
