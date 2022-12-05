package com.yy.cloud;

import com.yy.enums.OssTypeEnum;
import com.yy.utils.ModuleConstant;
import com.yy.commons.tools.utils.SpringContextUtils;
import com.yy.remote.ParamsRemoteService;

/**
 * 文件上传Factory
 *
 * @author shelei
 */
public final class OssFactory {
    private static ParamsRemoteService paramsRemoteService;

    static {
        OssFactory.paramsRemoteService = SpringContextUtils.getBean(ParamsRemoteService.class);
    }

    public static AbstractCloudStorageService build(){
        //获取云存储配置信息
        CloudStorageConfig config = paramsRemoteService.getValueObject(ModuleConstant.CLOUD_STORAGE_CONFIG_KEY, CloudStorageConfig.class);

        if(config.getType() == OssTypeEnum.QINIU.value()){
            return new QiniuCloudStorageService(config);
        }else if(config.getType() == OssTypeEnum.ALIYUN.value()){
            return new AliyunCloudStorageService(config);
        }else if(config.getType() == OssTypeEnum.QCLOUD.value()){
            return new QcloudCloudStorageService(config);
        }else if(config.getType() == OssTypeEnum.FASTDFS.value()){
            return new FastDFSCloudStorageService(config);
        }else if(config.getType() == OssTypeEnum.LOCAL.value()){
            return new LocalCloudStorageService(config);
        }else if(config.getType() == OssTypeEnum.MINIO.value()){
            return new MinioCloudStorageService(config);
        }

        return null;
    }

}