package com.yy.enums;

/**
 * 订单状态
 */
public enum OrderStatusEnum {
    /**
     * 已取消
     */
    CANCEL(-1),
    /**
     * 等待付款
     */
    WAITING(0),
    /**
     * 已完成
     */
    FINISH(1);

    private int value;

    OrderStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}