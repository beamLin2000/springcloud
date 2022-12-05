package com.yy.commons.security.exception;

import com.yy.commons.tools.exception.ErrorCode;
import com.yy.commons.tools.utils.JsonUtils;
import com.yy.commons.tools.utils.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 匿名用户(token不存在、错误)，异常处理器
 *
 * @author shelei
 */
public class SecurityAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(JsonUtils.toJsonString(new Result<>().error(ErrorCode.UNAUTHORIZED)));
    }
}