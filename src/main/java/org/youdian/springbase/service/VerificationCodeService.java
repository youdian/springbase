package org.youdian.springbase.service;

/**
 * 短信验证码服务
 * @author zhouzhou
 *
 */
public interface VerificationCodeService {
	/**
	 * 生成短信验证码并保存在redis中
	 * @param phone 手机号码
	 * @return
	 */
	public String generateCode(String phone);
	/**
	 * 判断验证码是否一致
	 * @param code 用户提交的验证码
	 * @return true 如果用户提交的验证码与生成的验证码一致
	 */
	public boolean isCodeIdentical(String phone, String code);
	/**
	 * 清除验证码
	 * @param phone
	 */
	public void clearCode(String phone);
}
