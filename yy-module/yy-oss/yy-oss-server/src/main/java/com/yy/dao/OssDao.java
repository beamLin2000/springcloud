package com.yy.dao;

import com.yy.commons.mybatis.dao.BaseDao;
import com.yy.entity.OssEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件上传
 *
 * @author shelei
 */
@Mapper
public interface OssDao extends BaseDao<OssEntity> {
	
}
