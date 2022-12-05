package com.yy.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 我的通知
 *
 * @author shelei
 */
@Data
@Accessors(chain = true)
@TableName("sys_notice_user")
public class SysNoticeUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 通知ID
	 */
	private Long noticeId;
	/**
	* 接收者ID
	*/
	private Long receiverId;
	/**
	* 阅读状态  0：未读  1：已读
	*/
	private Integer readStatus;
	/**
	* 阅读时间
	*/
	private Date readDate;
}