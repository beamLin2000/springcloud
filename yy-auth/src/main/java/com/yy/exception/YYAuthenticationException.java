package com.yy.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 认证异常类
 *
 * @author shelei
 */
public class YYAuthenticationException extends AuthenticationException {
    public YYAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public YYAuthenticationException(String msg) {
        super(msg);
    }
}
