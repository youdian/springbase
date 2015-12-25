package org.youdian.springbase.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.digest.DigestUtils;

public class EncryptUtils {

	private static final String SALT ="youdian543337061org";
	
	public static String stringEncryptedWithSHA256(String source) {
		if (source == null || source.isEmpty()) {
			throw new IllegalArgumentException("source can't be null or empty");
		}
		source = source + SALT;
		String result = null;
		try {
			result = DigestUtils.sha256Hex(source.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("source=" + source + ", encrypt result=" + result);
		return result;
	}
}
