package com.yy.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 上传信息
 *
 * @author shelei
 * @since 1.1.0
 */
@Data
@ApiModel(value = "上传信息")
public class UploadDTO {
    @ApiModelProperty(value = "文件URL")
    private String url;
    @ApiModelProperty(value = "文件大小，单位字节")
    private Long size;

}
