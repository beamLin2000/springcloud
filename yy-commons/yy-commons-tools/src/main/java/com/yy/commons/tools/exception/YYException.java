package com.yy.commons.tools.exception;


import com.yy.commons.tools.utils.MessageUtils;

/**
 * 自定义异常
 *
 * @author shelei
 * @since 1.0.0
 */
public class YYException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    private int code;
	private String msg;

	public YYException(int code) {
		this.code = code;
		this.msg = MessageUtils.getMessage(code);
	}

	public YYException(int code, String... params) {
		this.code = code;
		this.msg = MessageUtils.getMessage(code, params);
	}

	public YYException(int code, Throwable e) {
		super(e);
		this.code = code;
		this.msg = MessageUtils.getMessage(code);
	}

	public YYException(int code, Throwable e, String... params) {
		super(e);
		this.code = code;
		this.msg = MessageUtils.getMessage(code, params);
	}

	public YYException(String msg) {
		super(msg);
		this.code = ErrorCode.INTERNAL_SERVER_ERROR;
		this.msg = msg;
	}

	public YYException(String msg, Throwable e) {
		super(msg, e);
		this.code = ErrorCode.INTERNAL_SERVER_ERROR;
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}