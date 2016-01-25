package org.youdian.springbase.resolver;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.youdian.springbase.annotation.CurrrentUser;
import org.youdian.springbase.interceptor.AuthInterceptor;
import org.youdian.springbase.model.User;
import org.youdian.springbase.service.RedisService;
/**
 * 负责解析 CurrentUser注解
 * @author zhouzhou
 *
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
	
	@Autowired
	RedisService redisService;
	
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return User.class.equals(parameter.getParameterType()) 
				&& parameter.hasParameterAnnotation(CurrrentUser.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
		String token = null;
		Cookie[] cookies = servletRequest.getCookies();
		if (cookies != null) {
			for (Cookie cookie: cookies) {
				String name = cookie.getName();
				String value = cookie.getValue();
				if (AuthInterceptor.TOKEN.equals(name)) {
					token = value;
				}
			}
		}
		if (token != null) {
			String uidStr = redisService.getValue(token);
			if (uidStr != null) {
				try {
					int uid = Integer.valueOf(uidStr);
					User user = new User();
					user.setUid(uid);
					return user;
				} catch(NumberFormatException e) {
					return null;
				}
			}
		}
		return null;
	}

}
