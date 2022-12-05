package com.yy.exception;


import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * 自定义异常
 *
 * @author shelei
 */
public class YYOAuth2Exception extends OAuth2Exception {
	private String msg;

	public YYOAuth2Exception(String msg) {
		super(msg);
		this.msg = msg;
	}

	public YYOAuth2Exception(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}