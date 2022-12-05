package com.yy.controller;

import cn.hutool.core.map.MapUtil;
import com.google.gson.Gson;
import com.yy.cloud.CloudStorageConfig;
import com.yy.cloud.OssFactory;
import com.yy.dto.UploadDTO;
import com.yy.entity.OssEntity;
import com.yy.enums.OssTypeEnum;
import com.yy.exception.ModuleErrorCode;
import com.yy.service.OssService;
import com.yy.utils.ModuleConstant;
import com.yy.commons.log.annotation.LogOperation;
import com.yy.commons.tools.page.PageData;
import com.yy.commons.tools.utils.Result;
import com.yy.commons.tools.validator.ValidatorUtils;
import com.yy.commons.tools.validator.group.AliyunGroup;
import com.yy.commons.tools.validator.group.QcloudGroup;
import com.yy.commons.tools.validator.group.QiniuGroup;
import com.yy.remote.ParamsRemoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件上传
 *
 * @author shelei
 */
@RestController
@RequestMapping("file")
@Api(tags="文件上传")
public class OssController {
	@Autowired
	private OssService ossService;
    @Autowired
    private ParamsRemoteService paramsRemoteService;

    private final static String KEY = ModuleConstant.CLOUD_STORAGE_CONFIG_KEY;

	@GetMapping("page")
	@ApiOperation(value = "分页")
	@PreAuthorize("hasAuthority('sys:oss:all')")
	public Result<PageData<OssEntity>> page(@ApiIgnore @RequestParam Map<String, Object> params){
		PageData<OssEntity> page = ossService.page(params);

		return new Result<PageData<OssEntity>>().ok(page);
	}

    @GetMapping("info")
	@ApiOperation(value = "云存储配置信息")
	@PreAuthorize("hasAuthority('sys:oss:all')")
    public Result<CloudStorageConfig> info(){
        CloudStorageConfig config = paramsRemoteService.getValueObject(KEY, CloudStorageConfig.class);

        return new Result<CloudStorageConfig>().ok(config);
    }

	@PostMapping
	@ApiOperation(value = "保存云存储配置信息")
	@LogOperation("保存云存储配置信息")
	@PreAuthorize("hasAuthority('sys:oss:all')")
	public Result saveConfig(@RequestBody CloudStorageConfig config){
		//校验类型
		ValidatorUtils.validateEntity(config);

		if(config.getType() == OssTypeEnum.QINIU.value()){
			//校验七牛数据
			ValidatorUtils.validateEntity(config, QiniuGroup.class);
		}else if(config.getType() == OssTypeEnum.ALIYUN.value()){
			//校验阿里云数据
			ValidatorUtils.validateEntity(config, AliyunGroup.class);
		}else if(config.getType() == OssTypeEnum.QCLOUD.value()){
			//校验腾讯云数据
			ValidatorUtils.validateEntity(config, QcloudGroup.class);
		}

		paramsRemoteService.updateValueByCode(KEY, new Gson().toJson(config));

		return new Result();
	}

	@PostMapping("upload")
	@ApiOperation(value = "上传文件")
	public Result<UploadDTO> upload(@RequestParam("file") MultipartFile file) throws Exception {
		if (file.isEmpty()) {
			return new Result<UploadDTO>().error(ModuleErrorCode.UPLOAD_FILE_EMPTY);
		}

		//上传文件
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		String url = OssFactory.build().uploadSuffix(file.getBytes(), extension);

		//保存文件信息
		OssEntity ossEntity = new OssEntity();
		ossEntity.setUrl(url);
		ossEntity.setCreateDate(new Date());
		ossService.insert(ossEntity);

		//文件信息
		UploadDTO dto = new UploadDTO();
		dto.setUrl(url);
		dto.setSize(file.getSize());

		return new Result<UploadDTO>().ok(dto);
	}

	@PostMapping("tinymce/upload")
	@ApiOperation(value = "TinyMCE上传文件")
	public Map<String, String> tinymceUpload(@RequestParam("file") MultipartFile file) throws Exception {
		if (file.isEmpty()) {
			return MapUtil.newHashMap();
		}

		//上传文件
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		String url = OssFactory.build().uploadSuffix(file.getBytes(), extension);

		//保存文件信息
		OssEntity ossEntity = new OssEntity();
		ossEntity.setUrl(url);
		ossEntity.setCreateDate(new Date());
		ossService.insert(ossEntity);

		Map<String, String> data = new HashMap<>(1);
		data.put("location", url);

		return data;
	}

	@DeleteMapping
	@ApiOperation(value = "删除")
	@LogOperation("删除")
	@PreAuthorize("hasAuthority('sys:oss:all')")
	public Result delete(@RequestBody Long[] ids){
		ossService.deleteBatchIds(Arrays.asList(ids));

		return new Result();
	}

}