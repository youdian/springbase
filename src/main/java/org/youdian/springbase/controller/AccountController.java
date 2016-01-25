package org.youdian.springbase.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.youdian.springbase.form.LoginForm;
import org.youdian.springbase.form.RegisterForm;
import org.youdian.springbase.interceptor.AuthInterceptor;
import org.youdian.springbase.model.User;
import org.youdian.springbase.service.RedisService;
import org.youdian.springbase.service.UserService;
import org.youdian.springbase.service.VerificationCodeService;
import org.youdian.springbase.util.EncryptUtils;
import org.youdian.springbase.util.PatternUtils;
import org.youdian.springbase.util.ResponseEntityUtil;
import org.youdian.springbase.util.StringUtils;

/**
 * 处理用户注册登录相关信息
 * @author zhouzhou
 *
 */
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
	
	@Autowired
	VerificationCodeService codeService;
	@Autowired
	UserService userService;
	@Autowired
	RedisService redisService;
	
	@ResponseBody
	@RequestMapping("/register")
	public ResponseEntity<?> register(@RequestBody RegisterForm registerForm) {
		String phone = registerForm.getPhone();
		String password = registerForm.getPassword();
		String verificationCode = registerForm.getVerifiCode();
		if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(password) 
				|| TextUtils.isEmpty(verificationCode)) {
			return ResponseEntityUtil.entityWithStatusCode(HttpStatus.BAD_REQUEST);
		}
		if (!codeService.isCodeIdentical(phone, verificationCode)) {
			return ResponseEntityUtil.entityWithSimpleResponse(-1, "短信验证码不正确", HttpStatus.BAD_REQUEST);
		}
		try {
			User user = new User();
			user.setPhone(Long.valueOf(phone));
			user.setPassword(password);
			userService.registerUserByPhone(user);
			codeService.clearCode(phone);
			return ResponseEntityUtil.entityWithStatusCode(HttpStatus.OK);
		} catch (NumberFormatException e)  {
			return ResponseEntityUtil.entityWithSimpleResponse(-2, "手机号码格式不正确", HttpStatus.BAD_REQUEST);
		}
	}
	
	@ResponseBody
	@RequestMapping("/code")
	public ResponseEntity<?> getCode(@RequestBody RegisterForm registerForm) {
		String phone = registerForm.getPhone();
		if (!PatternUtils.isPhoneNumber(phone)) {
			return ResponseEntityUtil.entityWithSimpleResponse(-1, "手机号码格式不正确", HttpStatus.BAD_REQUEST);
		}
		String code = codeService.generateCode(phone);
		return ResponseEntityUtil.entityWithData(code, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping("/phonelogin")
	public ResponseEntity<?> login(@RequestBody LoginForm loginForm, HttpServletResponse httpResponse) {
		String phone = loginForm.getPhone();
		String password = loginForm.getPassword();
		if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(password)) {
			return ResponseEntityUtil.entityWithStatusCode(HttpStatus.BAD_REQUEST);
		}
		User user = userService.selectUserByPhone(phone);
		if (user == null) {
			return ResponseEntityUtil.entityWithSimpleResponse(-1, "用户不存在", HttpStatus.NOT_FOUND);
		}
		String originalValue = user.getPhone() + user.getPassword();
		String token = EncryptUtils.stringEncryptedWithSHA256(originalValue);
		redisService.putValue(token, String.valueOf(user.getUid()));
		httpResponse.addCookie(new Cookie(AuthInterceptor.TOKEN, token));
		return ResponseEntityUtil.entityWithStatusCode(HttpStatus.OK);
	}
}
