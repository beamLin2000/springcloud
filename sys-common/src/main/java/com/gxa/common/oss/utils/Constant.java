package com.gxa.common.oss.utils;

import com.gxa.common.oss.validator.group.*;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * 常量
 *
 */
public class Constant {

    /**
     * 云服务商
     */
    public enum CloudService {
        /**
         * 七牛云
         */
        QINIU(1, QiniuGroup.class),
        /**
         * 阿里云
         */
        ALIYUN(2, AliyunGroup.class),
        /**
         * 腾讯云
         */
        TCLOUD(3, TcloudGroup.class),
        /**
         * FastDFS
         */
        FASTDFS(4, FastDFSGroup.class),
        /**
         * 本地上传
         */
        LOCAL(5, LocalGroup.class),
        /**
         * minio
         */
        MINIO(6, MinioGroup.class);

        private int value;

        private Class<?> validatorGroupClass;

        CloudService(int value, Class<?> validatorGroupClass) {
            this.value = value;
            this.validatorGroupClass = validatorGroupClass;
        }

        public int getValue() {
            return value;
        }

        public Class<?> getValidatorGroupClass() {
            return this.validatorGroupClass;
        }

        public static CloudService getByValue(Integer value) {
            Optional<CloudService> first = Stream.of(CloudService.values()).filter(cs -> value.equals(cs.value)).findFirst();
            if (!first.isPresent()) {
                throw new IllegalArgumentException("非法的枚举值:" + value);
            }
            return first.get();
        }
    }

}
 
