package com.gxa.common.interceptor;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {
    private final String EXCLUDE_URI = "/login";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1、获取token
        String token = request.getHeader("token");
        //2、看请求是什么，有的请求不需要token
        String uri = request.getRequestURI();
        if(EXCLUDE_URI.contains(uri)){
            return true;
        }
        //3、判断token
        if(!StringUtils.isNotEmpty(token)){
            //写一个json
            return false;
        }
        //4、一定是带了token，验证该token,调用redis去获取 ，获取不到说明没有登录 写 json return false;
         return true;
    }
}
