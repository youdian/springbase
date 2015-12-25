package org.youdian.springbase.util;

public class PatternUtils {

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
