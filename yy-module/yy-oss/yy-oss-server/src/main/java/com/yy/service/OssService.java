package com.yy.service;

import com.yy.commons.mybatis.service.BaseService;
import com.yy.entity.OssEntity;
import com.yy.commons.tools.page.PageData;

import java.util.Map;

/**
 * 文件上传
 *
 * @author shelei
 */
public interface OssService extends BaseService<OssEntity> {

	PageData<OssEntity> page(Map<String, Object> params);
}
