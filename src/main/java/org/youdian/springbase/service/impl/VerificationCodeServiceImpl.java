package org.youdian.springbase.service.impl;

import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.youdian.springbase.service.RedisService;
import org.youdian.springbase.service.VerificationCodeService;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {
	private static final String PREFIX = "code_";
	@Autowired
	RedisService redisService;
	
	@Override
	public String generateCode(String phone) {
		if (TextUtils.isEmpty(phone)) {
			return "0000";
		}
		String code = "1124";
		redisService.putValue(PREFIX + phone, code);
		return code;
	}

	@Override
	public boolean isCodeIdentical(String phone, String code) {
		if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(code)) {
			return false;
		}
		String redisValue = redisService.getValue(PREFIX + phone);
		return code.equals(redisValue);
	}

	@Override
	public void clearCode(String phone) {
		redisService.putValue(PREFIX + phone, null);
		
	}

}
