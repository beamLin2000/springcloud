package com.yy.annotation;

import java.lang.annotation.*;

/**
 * 登录效验
 * @author shelei
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
