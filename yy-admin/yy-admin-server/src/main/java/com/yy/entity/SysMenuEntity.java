package com.yy.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yy.commons.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 菜单管理
 *
 * @author shelei
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_menu")
public class SysMenuEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/**
	 * 上级ID，一级菜单为0
	 */
	private Long pid;
	/**
	 * 菜单名称
	 */
	@TableField(exist = false)
	private String name;
	/**
	 * 菜单URL
	 */
	private String url;
	/**
	 * 类型   0：菜单   1：按钮
	 */
	private Integer menuType;
	/**
	 * 打开方式   0：内部   1：外部
	 */
	private Integer openStyle;
	/**
	 * 菜单图标
	 */
	private String icon;
	/**
	 * 权限标识，如：sys:menu:save
	 */
	private String permissions;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 删除标识  0：未删除    1：删除
	 */
	@TableField(fill = FieldFill.INSERT)
	private Integer delFlag;
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

	/**
	 * 上级菜单名称
	 */
	@TableField(exist = false)
	private String parentName;

}