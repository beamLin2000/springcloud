package com.yy.commons.security.constant;

/**
 * 资源常量
 *
 * @author shelei
 */
public class ResourceConstant {
    /**
     * 不进行认证的URL
     */
    public static final String [] IGNORING_URLS = {
        "/actuator/**",
        "/v2/api-docs",
        "/webjars/**",
        "/swagger/**",
        "/swagger-resources/**",
        "/doc.html"
    };

}
