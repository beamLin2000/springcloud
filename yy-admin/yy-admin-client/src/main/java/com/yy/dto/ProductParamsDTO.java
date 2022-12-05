package com.yy.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * 产品参数管理
 *
 * @author shelei
 */
@Data
@ApiModel(value = "产品参数管理")
public class ProductParamsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "参数名")
	private String paramName;

	@ApiModelProperty(value = "参数值")
	private String paramValue;
}