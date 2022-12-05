package com.yy.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yy.commons.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 公众号自定义菜单
 *
 * @author shelei
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("mp_menu")
public class MpMenuEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/**
	* 菜单json数据
	*/
	private String menu;
	/**
	* AppID
	*/
	private String appId;
	/**
	* 更新者
	*/
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Long updater;
	/**
	* 更新时间
	*/
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateDate;
}