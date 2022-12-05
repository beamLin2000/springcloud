package com.yy.commons.log.annotation;

import java.lang.annotation.*;

/**
 * 操作日志注解
 *
 * @author shelei
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogOperation {
    String value() default "";
}