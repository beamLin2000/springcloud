package com.yy.enums;

/**
 * 行政区域  级别枚举
 *
 * @author shelei
 */
public enum RegionLevelEnum {
    ONE(1),
    TWO(2),
    THREE(3);

    private int value;

    RegionLevelEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
