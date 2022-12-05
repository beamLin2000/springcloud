package com.gxa.common.oss.config;

import com.gxa.common.oss.validator.group.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 存储配置信息
 *
 * @author shelei
 */
@Data
@ApiModel(value = "存储配置信息")
@Component("storageConfig")
@ConfigurationProperties("storage.config")
public class StorageConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "类型 1：七牛  2：阿里云  3：腾讯云   4：FastDFS   5：本地上传    6：minio")
    @Range(min=1, max=6, message = "类型错误")
    private Integer type;

    @ApiModelProperty(value = "七牛绑定的域名")
    @NotBlank(message="七牛绑定的域名不能为空", groups = QiniuGroup.class)
    @URL(message = "七牛绑定的域名格式不正确", groups = QiniuGroup.class)
    private String qiniuDomain;

    @ApiModelProperty(value = "七牛路径前缀")
    private String qiniuPrefix;

    @ApiModelProperty(value = "七牛ACCESS_KEY")
    @NotBlank(message="七牛AccessKey不能为空", groups = QiniuGroup.class)
    private String qiniuAccessKey;

    @ApiModelProperty(value = "七牛SECRET_KEY")
    @NotBlank(message="七牛SecretKey不能为空", groups = QiniuGroup.class)
    private String qiniuSecretKey;

    @ApiModelProperty(value = "七牛存储空间名")
    @NotBlank(message="七牛空间名不能为空", groups = QiniuGroup.class)
    private String qiniuBucketName;

    @ApiModelProperty(value = "阿里云绑定的域名")
    @NotBlank(message="阿里云绑定的域名不能为空", groups = AliyunGroup.class)
    @URL(message = "阿里云绑定的域名格式不正确", groups = AliyunGroup.class)
    private String aliyunDomain;

    @ApiModelProperty(value = "阿里云路径前缀")
    private String aliyunPrefix;

    @ApiModelProperty(value = "阿里云EndPoint")
    @NotBlank(message="阿里云EndPoint不能为空", groups = AliyunGroup.class)
    private String aliyunEndPoint;

    @ApiModelProperty(value = "阿里云AccessKeyId")
    @NotBlank(message="阿里云AccessKeyId不能为空", groups = AliyunGroup.class)
    private String aliyunAccessKeyId;

    @ApiModelProperty(value = "阿里云AccessKeySecret")
    @NotBlank(message="阿里云AccessKeySecret不能为空", groups = AliyunGroup.class)
    private String aliyunAccessKeySecret;

    @ApiModelProperty(value = "阿里云BucketName")
    @NotBlank(message="阿里云BucketName不能为空", groups = AliyunGroup.class)
    private String aliyunBucketName;

    @ApiModelProperty(value = "腾讯云绑定的域名")
    @NotBlank(message="腾讯云绑定的域名不能为空", groups = TcloudGroup.class)
    @URL(message = "腾讯云绑定的域名格式不正确", groups = TcloudGroup.class)
    private String tcloudDomain;

    @ApiModelProperty(value = "腾讯云路径前缀")
    private String tcloudPrefix;

    @ApiModelProperty(value = "腾讯云AppId")
    @NotNull(message="腾讯云AppId不能为空", groups = TcloudGroup.class)
    private Integer tcloudAppId;

    @ApiModelProperty(value = "腾讯云SecretId")
    @NotBlank(message="腾讯云SecretId不能为空", groups = TcloudGroup.class)
    private String tcloudSecretId;

    @ApiModelProperty(value = "腾讯云SecretKey")
    @NotBlank(message="腾讯云SecretKey不能为空", groups = TcloudGroup.class)
    private String tcloudSecretKey;

    @ApiModelProperty(value = "腾讯云BucketName")
    @NotBlank(message="腾讯云BucketName不能为空", groups = TcloudGroup.class)
    private String tcloudBucketName;

    @ApiModelProperty(value = "腾讯云COS所属地区")
    @NotBlank(message="所属地区不能为空", groups = TcloudGroup.class)
    private String tcloudRegion;

    @ApiModelProperty(value = "FastDFS绑定的域名")
    @NotBlank(message="FastDFS绑定的域名不能为空", groups = FastDFSGroup.class)
    @URL(message = "FastDFS绑定的域名格式不正确", groups = FastDFSGroup.class)
    private String fastdfsDomain;

    @ApiModelProperty(value = "本地上传绑定的域名")
    @NotBlank(message="本地上传绑定的域名不能为空", groups = LocalGroup.class)
    @URL(message = "本地上传绑定的格式不正确", groups = LocalGroup.class)
    private String localDomain;

    @ApiModelProperty(value = "本地上传路径前缀")
    private String localPrefix;

    @ApiModelProperty(value = "本地上传存储目录")
    @NotBlank(message="本地上传存储目录不能为空", groups = LocalGroup.class)
    private String localPath;

    @ApiModelProperty(value = "Minio EndPoint")
    @NotBlank(message="Minio EndPoint不能为空", groups = MinioGroup.class)
    private String minioEndPoint;

    @ApiModelProperty(value = "accessKey")
    @NotBlank(message="Minio accessKey不能为空", groups = MinioGroup.class)
    private String minioAccessKey;

    @ApiModelProperty(value = "secretKey")
    @NotBlank(message="Minio secretKey不能为空", groups = MinioGroup.class)
    private String minioSecretKey;

    @ApiModelProperty(value = "BucketName")
    @NotBlank(message="Minio BucketName不能为空", groups = MinioGroup.class)
    private String minioBucketName;

    @ApiModelProperty(value = "MinIO上传路径前缀")
    private String minioPrefix;

}
 
