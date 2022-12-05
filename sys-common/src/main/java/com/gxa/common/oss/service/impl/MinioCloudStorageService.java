package com.gxa.common.oss.service.impl;

import com.gxa.common.exception.ResultException;
import com.gxa.common.oss.config.StorageConfig;
import com.gxa.common.oss.service.AbstractStorageService;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * MinIO 存储
 *
 * @author shelei
 */
public class MinioCloudStorageService extends AbstractStorageService {
    private MinioClient minioClient;

    public MinioCloudStorageService(StorageConfig config){
        this.config = config;
        //初始化
        init();
    }

    private void init(){
        minioClient = MinioClient.builder().endpoint(config.getMinioEndPoint())
            .credentials(config.getMinioAccessKey(), config.getMinioSecretKey()).build();
    }

    @Override
    public String upload(byte[] data, String path) {
        return upload(new ByteArrayInputStream(data), path);
    }

    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            //如果BucketName不存在，则创建
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(config.getMinioBucketName()).build());
            if (!found) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(config.getMinioBucketName()).build());
            }

            minioClient.putObject(
                PutObjectArgs.builder()
                    .bucket(config.getMinioBucketName())
                    .object(path)
                    .stream(inputStream, inputStream.available(), -1)
                    .build()
            );

        } catch (Exception e) {
            throw new ResultException("上传文件失败，请核对minio配置信息", e);
        }

        return config.getMinioEndPoint() + "/" + config.getMinioBucketName() + "/" + path;
    }

    @Override
    public String uploadSuffix(byte[] data, String suffix) {
        return upload(data, getPath(config.getMinioPrefix(), suffix));
    }

    @Override
    public String uploadSuffix(InputStream inputStream, String suffix) {
        return upload(inputStream, getPath(config.getMinioPrefix(), suffix));
    }
}
 
