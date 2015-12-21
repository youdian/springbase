package org.youdian.springbase.interceptor;

import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.youdian.springbase.annotation.AuthRequired;
import org.youdian.springbase.annotation.AuthRequired.AuthType;
import org.youdian.springbase.model.User;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	public static final String TOKEN = "token";
	public static final String TOKEN_SECRET = "tokenSecret";
	public static final String ATTR_CURRENT_USER = "currentUser";
	private static final int INVALID_USER_ID = -1;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod hm = (HandlerMethod) handler;
		Method method = hm.getMethod();
		if (method.isAnnotationPresent(AuthRequired.class)) {
			String token = null;
			String tokenSecret = null;
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie: cookies) {
					System.out.println(cookie);
					String name = cookie.getName();
					String value = cookie.getValue();
					if (TOKEN.equals(name)) {
						token = value;
					} else if (TOKEN_SECRET.equals(name)) {
						tokenSecret = value;
					}
				}
			}
			System.out.println("token=" + token + ",secret=" + tokenSecret);
			AuthType authType = method.getAnnotation(AuthRequired.class).value();
			switch (authType) {
			case OPTIONAL:
				System.out.println("authType=optional");
				if (token != null && tokenSecret != null) {
					User user = getUserId(token, tokenSecret);
					if (user.getId() != INVALID_USER_ID) {
						request.setAttribute(ATTR_CURRENT_USER, user);
					}
				}
				break;
			case REQUIRED:
				System.out.println("authType=required");
				if (token != null || tokenSecret != null) {
					User user = getUserId(token, tokenSecret);
					if (user.getId() == INVALID_USER_ID) {
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

	private User getUserId(String token, String tokenSecret) {
		User user = new User();
		user.setId(2);
		user.setName("authUser");
		return user;
	}
}
