package com.yy.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 注册表单
 *
 * @author shelei
 */
@Data
@ApiModel(value = "注册表单")
public class RegisterDTO {
    @ApiModelProperty(value = "手机号")
    @NotBlank(message="{api.mobile.require}")
    private String mobile;

    @ApiModelProperty(value = "密码")
    @NotBlank(message="{api.password.require}")
    private String password;

}
