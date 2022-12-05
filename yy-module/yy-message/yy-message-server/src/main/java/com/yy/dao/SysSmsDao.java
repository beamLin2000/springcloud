package com.yy.dao;

import com.yy.commons.mybatis.dao.BaseDao;
import com.yy.entity.SysSmsEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 短信
 *
 * @author shelei
 */
@Mapper
public interface SysSmsDao extends BaseDao<SysSmsEntity> {
	
}
