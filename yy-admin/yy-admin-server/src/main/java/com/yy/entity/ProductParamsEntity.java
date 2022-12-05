package com.yy.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yy.commons.mybatis.entity.BaseEntity;
import com.yy.commons.tools.utils.DateUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 产品参数管理
 * @author shelei
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("tb_product_params")
public class ProductParamsEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 参数名
     */
	private String paramName;
    /**
     * 参数值
     */
	private String paramValue;
    /**
     * 产品ID
     */
	private Long productId;
    /**
     * 更新者
     */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Long updater;
    /**
     * 更新时间
     */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date updateDate;
}