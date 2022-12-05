package com.yy.dao;

import com.yy.commons.mybatis.dao.BaseDao;
import com.yy.entity.ProductParamsEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 产品参数管理
 *
 * @author shelei
 */
@Mapper
public interface ProductParamsDao extends BaseDao<ProductParamsEntity> {

    /**
     * 根据产品id，删除产品参数
     */
    void deleteByProductIds(Long[] productIds);
}