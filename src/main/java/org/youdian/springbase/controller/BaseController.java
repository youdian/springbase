package org.youdian.springbase.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.youdian.springbase.interceptor.AuthInterceptor;
import org.youdian.springbase.model.User;

public class BaseController {
	
	@ModelAttribute("currentUser")
	public User getCurrentUser(HttpServletRequest request) {
		User user = (User) request.getAttribute(AuthInterceptor.ATTR_CURRENT_USER);
		return user;
	}
}
