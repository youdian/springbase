package org.youdian.springbase.controller;

import java.util.List;

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
		user.setName("小子奥");
		userService.insertUser(user);
		return user;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public User update() {
		User user = new User();
		user.setId(3);
		user.setEmail("aa@bb.com");
		userService.updateUser(user);
		return user;
				
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public void delete() {
		int id = 4;
		User user = new User();
		user.setId(id);
		userService.deleteUser(user);
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public List<User> listUser() {
		return userService.listUser();
	}
	
	@ResponseBody
	@RequestMapping("/")
	public User selectUser() {
		int id = 5;
		return userService.selectUser(id);
	}
}
