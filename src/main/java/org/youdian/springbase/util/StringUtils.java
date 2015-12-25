package org.youdian.springbase.util;

import java.io.UnsupportedEncodingException;

public class StringUtils {
	
	/**
	 * url上中文文字转码
	 * @param value
	 * @return
	 */
	public static String encodeChineseUrl(String value) {
		byte bytes[] = null;
	    try {
	    	bytes = value.getBytes("ISO-8859-1"); //以"ISO-8859-1"方式解析name字符串
	    	value= new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    return value;
	}
	
	/**
	 * string为null或者为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.isEmpty();
	}
}
