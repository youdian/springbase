package org.youdian.springbase.util;

/**
 * 模式匹配类
 * @author zhouzhou
 *
 */
public class PatternUtils {
	
	/**
	 * 判断一段数字是否是手机号
	 * @param phone
	 * @return
	 */
	public static boolean isPhoneNumber(String phone) {
		if (phone == null || phone.isEmpty()) {
			return false;
		}
		if (phone.length() == 11) {
			return true;
		}
		return false;
	}
}
