package org.youdian.springbase.model;

/**
 * 请求错误响应
 * @author zhouzhou
 *
 */
public class SimpleResponse {
	/**
	 * 错误码
	 */
	private int errorCode;
	/**
	 * 错误描述
	 */
	private String desc;
	
	public static SimpleResponse create(int errorCode, String desc) {
		return new SimpleResponse(errorCode, desc);
	}
	
	private SimpleResponse() {
		
	}
	
	public SimpleResponse(int errorCode, String desc) {
		this.errorCode = errorCode;
		this.desc = desc;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
