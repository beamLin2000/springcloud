package com.yy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yy.commons.tools.utils.DateUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
* 通知管理
*
 * @author shelei
*/
@Data
@ApiModel(value = "通知管理")
public class SysNoticeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "通知类型")
    private Integer noticeType;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "内容")
    private String content;
    @ApiModelProperty(value = "接收者类型  0：全部  1：部门")
    private Integer receiverType;
    @ApiModelProperty(value = "接收者ID，用逗号分开")
    private String receiverTypeIds;
    @ApiModelProperty(value = "接收者ID列表")
    private List<Long> receiverTypeList;
    @ApiModelProperty(value = "发送状态  0：草稿  1：已发布")
    private Integer status;
    @ApiModelProperty(value = "发送者")
    private String senderName;
    @ApiModelProperty(value = "发送时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date senderDate;
    @ApiModelProperty(value = "创建者")
    private Long creator;
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date createDate;
    @ApiModelProperty(value = "接收者")
    private String receiverName;
    @ApiModelProperty(value = "阅读时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date readDate;
    @ApiModelProperty(value = "阅读状态  0：未读  1：已读")
    private Integer readStatus;
}