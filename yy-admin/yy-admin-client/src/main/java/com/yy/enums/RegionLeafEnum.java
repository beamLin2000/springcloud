package com.yy.enums;

/**
 * 叶子节点枚举
 *
 * @author shelei
 */
public enum RegionLeafEnum {
    YES(1),
    NO(0);

    private int value;

    RegionLeafEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
