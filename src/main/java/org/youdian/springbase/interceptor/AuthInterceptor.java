package org.youdian.springbase.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.youdian.springbase.annotation.AuthRequired;
import org.youdian.springbase.annotation.AuthRequired.AuthType;
import org.youdian.springbase.model.User;
import org.youdian.springbase.service.RedisService;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	public static final String TOKEN = "token";
	public static final String ATTR_CURRENT_USER = "currentUser";
	
	@Autowired
	RedisService redisService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod hm = (HandlerMethod) handler;
		Method method = hm.getMethod();
		if (method.isAnnotationPresent(AuthRequired.class)) {
			String token = null;
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie: cookies) {
					System.out.println(cookie);
					String name = cookie.getName();
					String value = cookie.getValue();
					if (TOKEN.equals(name)) {
						token = value;
					}
				}
			}
			System.out.println("token=" + token);
			AuthType authType = method.getAnnotation(AuthRequired.class).value();
			switch (authType) {
			case OPTIONAL:
				System.out.println("authType=optional");
				if (token != null) {
					User user = getUserId(token);
					if (user.getUid() != User.INVALID_USER_ID) {
						request.setAttribute(ATTR_CURRENT_USER, user);
					}
				}
				break;
			case REQUIRED:
				System.out.println("authType=required");
				if (token != null) {
					User user = getUserId(token);
					if (user.getUid() == User.INVALID_USER_ID) {
						response.setStatus(403);
						return false;
					}
					request.setAttribute(ATTR_CURRENT_USER, user);
				} else {
					response.setStatus(403);
					return false;
				}
				break;
			default:				
				break;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	private User getUserId(String token) {
		int uid = redisService.getUserId(token);
		System.out.print(uid);
		User user = new User();
		user.setUid(uid);
		user.setName("authUser");
		return user;
	}
}
