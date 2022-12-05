package com.yy.service;

import com.yy.commons.mybatis.service.CrudService;
import com.yy.dto.ProductDTO;
import com.yy.entity.ProductEntity;

/**
 * 产品管理
 *
 * @author shelei
 */
public interface ProductService extends CrudService<ProductEntity, ProductDTO> {

}