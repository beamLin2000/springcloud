package com.gxa.common.oss.service.impl;

import com.gxa.common.exception.ResultException;
import com.gxa.common.oss.config.StorageConfig;
import com.gxa.common.oss.service.AbstractStorageService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 腾讯云存储
 *
 * @author shelei
 */
public class TcloudCloudStorageService extends AbstractStorageService {
    private COSCredentials credentials;
    private ClientConfig clientConfig;

    public TcloudCloudStorageService(StorageConfig config){
        this.config = config;

        //初始化
        init();
    }

    private void init(){
        //1、初始化用户身份信息(secretId, secretKey)
        credentials = new BasicCOSCredentials(config.getTcloudSecretId(), config.getTcloudSecretKey());
     
     //2、设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        clientConfig = new ClientConfig(new Region(config.getTcloudRegion()));
    }

    @Override
    public String upload(byte[] data, String path) {
        return upload(new ByteArrayInputStream(data), path);
    }

    @Override
    public String upload(InputStream inputStream, String path) {
     try {
            COSClient client = new COSClient(credentials, clientConfig);

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(inputStream.available());
            String bucketName = config.getTcloudBucketName() +"-"+ config.getTcloudAppId();
            PutObjectRequest request = new PutObjectRequest(bucketName, path, inputStream, metadata);
            PutObjectResult result = client.putObject(request);
            
            client.shutdown();
            if(result.getETag() == null){
                throw new ResultException("文件上传失败，请核对腾讯配置信息" );
            }
        } catch (IOException e) {
            throw new ResultException("文件上传失败，请核对腾讯配置信息" ,e);
        }

        return config.getTcloudDomain() + "/" + path;
    }

    @Override
    public String uploadSuffix(byte[] data, String suffix) {
        return upload(data, getPath(config.getTcloudPrefix(), suffix));
    }

    @Override
    public String uploadSuffix(InputStream inputStream, String suffix) {
        return upload(inputStream, getPath(config.getTcloudPrefix(), suffix));
    }
}
 
