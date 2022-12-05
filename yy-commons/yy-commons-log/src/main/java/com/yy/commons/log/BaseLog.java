package com.yy.commons.log;

import lombok.Data;

import java.io.Serializable;

/**
 * Log基类
 *
 * @author shelei
 * @since 1.0.0
 */
@Data
public abstract class BaseLog implements Serializable {
    /**
     * 日志类型
     */
    private Integer type;

}