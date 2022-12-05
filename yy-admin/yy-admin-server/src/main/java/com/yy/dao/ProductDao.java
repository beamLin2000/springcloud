package com.yy.dao;

import com.yy.commons.mybatis.dao.BaseDao;
import com.yy.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 产品管理
 *
 * @author shelei
 */
@Mapper
public interface ProductDao extends BaseDao<ProductEntity> {
	
}