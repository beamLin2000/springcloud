package com.yy.dao;

import com.yy.commons.mybatis.dao.BaseDao;
import com.yy.entity.AlipayNotifyLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 支付宝回调日志
*
 * @author shelei
*/
@Mapper
public interface AlipayNotifyLogDao extends BaseDao<AlipayNotifyLogEntity> {
	
}