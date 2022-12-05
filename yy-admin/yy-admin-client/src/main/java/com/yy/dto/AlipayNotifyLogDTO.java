package com.yy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yy.commons.tools.utils.DateUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
* 支付宝回调日志
*
 * @author shelei
*/
@Data
@ApiModel(value = "支付宝回调日志")
public class AlipayNotifyLogDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @ApiModelProperty(value = "订单号")
    private Long outTradeNo;
    @ApiModelProperty(value = "订单金额")
    private BigDecimal totalAmount;
    @ApiModelProperty(value = "付款金额")
    private BigDecimal buyerPayAmount;
    @ApiModelProperty(value = "实收金额")
    private BigDecimal receiptAmount;
    @ApiModelProperty(value = "开票金额")
    private BigDecimal invoiceAmount;
    @ApiModelProperty(value = "通知校验ID")
    private String notifyId;
    @ApiModelProperty(value = "买家支付宝用户号")
    private String buyerId;
    @ApiModelProperty(value = "卖家支付宝用户号")
    private String sellerId;
    @ApiModelProperty(value = "支付宝交易号")
    private String tradeNo;
    @ApiModelProperty(value = "交易状态")
    private String tradeStatus;
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date createDate;

}