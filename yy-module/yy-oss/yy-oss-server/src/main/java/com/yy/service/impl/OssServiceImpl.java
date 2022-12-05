package com.yy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yy.commons.mybatis.service.impl.BaseServiceImpl;
import com.yy.dao.OssDao;
import com.yy.entity.OssEntity;
import com.yy.service.OssService;
import com.yy.commons.tools.constant.Constant;
import com.yy.commons.tools.page.PageData;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OssServiceImpl extends BaseServiceImpl<OssDao, OssEntity> implements OssService {

	@Override
	public PageData<OssEntity> page(Map<String, Object> params) {
		IPage<OssEntity> page = baseDao.selectPage(
			getPage(params, Constant.CREATE_DATE, false),
			new QueryWrapper<>()
		);
		return getPageData(page, OssEntity.class);
	}
}
