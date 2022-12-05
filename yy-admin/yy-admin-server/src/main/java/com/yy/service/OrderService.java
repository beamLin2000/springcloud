package com.yy.service;

import com.yy.commons.mybatis.service.CrudService;
import com.yy.dto.OrderDTO;
import com.yy.entity.OrderEntity;

/**
 * 订单
 *
 * @author shelei
 */
public interface OrderService extends CrudService<OrderEntity, OrderDTO> {


    OrderEntity getByOrderId(Long orderId);

    /**
     * 支付成功
     * @param order 订单
     */
    void paySuccess(OrderEntity order);
}