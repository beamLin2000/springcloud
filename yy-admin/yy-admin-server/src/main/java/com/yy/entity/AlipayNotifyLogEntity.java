package com.yy.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("tb_alipay_notify_log")
public class AlipayNotifyLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long id;
	/**
	* 订单号
	*/
	private Long outTradeNo;
	/**
	* 订单金额
	*/
	private BigDecimal totalAmount;
	/**
	* 付款金额
	*/
	private BigDecimal buyerPayAmount;
	/**
	* 实收金额
	*/
	private BigDecimal receiptAmount;
	/**
	* 开票金额
	*/
	private BigDecimal invoiceAmount;
	/**
	* 通知校验ID
	*/
	private String notifyId;
	/**
	* 买家支付宝用户号
	*/
	private String buyerId;
	/**
	* 卖家支付宝用户号
	*/
	private String sellerId;
	/**
	* 支付宝交易号
	*/
	private String tradeNo;
	/**
	* 交易状态
	*/
	private String tradeStatus;
	/**
	* 创建时间
	*/
	@TableField(fill = FieldFill.INSERT)
	private Date createDate;
}