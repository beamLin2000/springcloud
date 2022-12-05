package com.yy.dao;

import com.yy.commons.mybatis.dao.BaseDao;
import com.yy.entity.SysPostEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 岗位管理
 * @author shelei
*/
@Mapper
public interface SysPostDao extends BaseDao<SysPostEntity> {
	
}