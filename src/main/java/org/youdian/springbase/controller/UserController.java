package org.youdian.springbase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.youdian.springbase.annotation.AuthRequired;
import org.youdian.springbase.model.User;
import org.youdian.springbase.service.UserService;
import org.youdian.springbase.util.ResponseEntityUtil;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController{
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/", method = RequestMethod.PUT)
	public ResponseEntity<?> newUser(@RequestBody User user) {
		if (user.getName() == null) {
			return ResponseEntityUtil.entityWithSimpleResponse(-1, "用户名不能为空", HttpStatus.BAD_REQUEST);
		}
		userService.insertUser(user);
		return ResponseEntityUtil.entityWithStatusCode(HttpStatus.CREATED);
	}
	//使用@RequestBody时，请求的实体类型需要设置为application/json
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	@AuthRequired
	public ResponseEntity<?> update(@ModelAttribute("currentUser") User currentUser, @PathVariable int id, @RequestBody User user) {
		user.setUid(id);
		System.out.println(currentUser);
		if (currentUser.equals(user)) {
			userService.updateUser(user);
			return ResponseEntityUtil.entityWithStatusCode(HttpStatus.OK);	
		} else {
			return ResponseEntityUtil.entityWithStatusCode(HttpStatus.FORBIDDEN);
		}
				
	}
	
	@AuthRequired
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@ModelAttribute("currentUser") User currentUser, @PathVariable int id) {
		if (currentUser.getUid() == id) {
			userService.deleteUser(id);
			return ResponseEntityUtil.entityWithStatusCode(HttpStatus.OK);	
		} else {
			return ResponseEntityUtil.entityWithStatusCode(HttpStatus.FORBIDDEN);	
		}
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<?> listUser() {
		List<User> users = userService.listUser();
		return ResponseEntityUtil.entityWithData(users, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public ResponseEntity<?> searchUser(@RequestParam String name) {
		List<User> users = userService.searchUser(name);
		return ResponseEntityUtil.entityWithData(users, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> selectUser(@PathVariable int id) {
		User user = userService.selectUser(id);
		if (user != null) {
			return ResponseEntityUtil.entityWithData(user, HttpStatus.OK);
		} else {
			return ResponseEntityUtil.entityWithSimpleResponse(-1, "用户不存在", HttpStatus.BAD_REQUEST);
		}

	}
}
