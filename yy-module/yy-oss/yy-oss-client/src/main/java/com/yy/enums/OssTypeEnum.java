package com.yy.enums;

/**
 * OSS类型枚举
 *
 * @author shelei
 * @since 1.1.0
 */
public enum OssTypeEnum {
    /**
     * 七牛云
     */
    QINIU(1),
    /**
     * 阿里云
     */
    ALIYUN(2),
    /**
     * 腾讯云
     */
    QCLOUD(3),
    /**
     * FASTDFS
     */
    FASTDFS(4),
    /**
     * 本地
     */
    LOCAL(5),
    /**
     * MinIO
     */
    MINIO(6);

    private int value;

    OssTypeEnum(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}