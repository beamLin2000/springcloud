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
 * 订单
 *
 * @author shelei
 */
@Data
@TableName("tb_order")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long id;
	/**
	* 订单ID
	*/
	private Long orderId;
	/**
	* 产品ID
	*/
	private Long productId;
	/**
	* 产品名称
	*/
	private String productName;
	/**
	* 支付金额
	*/
	private BigDecimal payAmount;
	/**
	* 订单状态
	*/
	private Integer status;
	/**
	* 购买者ID
	*/
	private Long userId;
	/**
	* 支付时间
	*/
	private Date payAt;
	/**
	* 下单时间
	*/
	@TableField(fill = FieldFill.INSERT)
	private Date createDate;

}