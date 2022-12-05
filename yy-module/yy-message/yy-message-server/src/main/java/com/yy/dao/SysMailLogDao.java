package com.yy.dao;

import com.yy.commons.mybatis.dao.BaseDao;
import com.yy.entity.SysMailLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 邮件发送记录
 *
 * @author shelei
 */
@Mapper
public interface SysMailLogDao extends BaseDao<SysMailLogEntity> {
	
}
