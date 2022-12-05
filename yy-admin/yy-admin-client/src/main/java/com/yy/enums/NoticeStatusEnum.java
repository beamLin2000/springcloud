
package com.yy.enums;

/**
 * 通知状态枚举
 *
 * @author shelei
 */
public enum NoticeStatusEnum {
    /**
     * 草稿
     */
    DRAFT(0),
    /**
     * 发送
     */
    SEND(1);

    private int value;

    NoticeStatusEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
