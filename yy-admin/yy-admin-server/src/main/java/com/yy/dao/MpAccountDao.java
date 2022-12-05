package com.yy.dao;

import com.yy.commons.mybatis.dao.BaseDao;
import com.yy.entity.MpAccountEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 公众号账号管理
*
* @author shelei
*/
@Mapper
public interface MpAccountDao extends BaseDao<MpAccountEntity> {
	
}