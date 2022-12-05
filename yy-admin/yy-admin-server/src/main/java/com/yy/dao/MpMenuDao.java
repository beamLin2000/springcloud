package com.yy.dao;


import com.yy.commons.mybatis.dao.BaseDao;
import com.yy.entity.MpMenuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 公众号自定义菜单
*
* @author shelei
*/
@Mapper
public interface MpMenuDao extends BaseDao<MpMenuEntity> {
	
}