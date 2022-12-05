package com.yy.service;

import com.yy.commons.mybatis.service.CrudService;
import com.yy.dto.AlipayNotifyLogDTO;
import com.yy.entity.AlipayNotifyLogEntity;

/**
 * 支付宝回调日志
 * @author shelei
 */
public interface AlipayNotifyLogService extends CrudService<AlipayNotifyLogEntity, AlipayNotifyLogDTO> {

}