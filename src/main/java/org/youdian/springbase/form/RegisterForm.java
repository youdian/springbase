package org.youdian.springbase.form;

/**
 * 手机号注册form
 * @author zhouzhou
 *
 */
public class RegisterForm {
	
	/**
	 * 手机号码
	 */
	private String phone;
	/**
	 * 短信验证码
	 */
	private String verifiCode;
	/**
	 * 密码
	 */
	private String password;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getVerifiCode() {
		return verifiCode;
	}
	public void setVerifiCode(String verifiCode) {
		this.verifiCode = verifiCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
