package com.yy.service;


import com.yy.commons.mybatis.service.BaseService;
import com.yy.dto.ProductParamsDTO;
import com.yy.entity.ProductParamsEntity;

import java.util.List;

/**
 * 产品参数管理
 *
 * @author shelei
 */
public interface ProductParamsService extends BaseService<ProductParamsEntity> {

    void saveOrUpdate(Long productId, List<ProductParamsDTO> list);

    void deleteByProductIds(Long[] productIds);

    List<ProductParamsDTO> getList(Long productId);
}