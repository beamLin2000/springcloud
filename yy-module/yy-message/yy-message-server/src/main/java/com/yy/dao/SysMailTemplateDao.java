package com.yy.dao;

import com.yy.commons.mybatis.dao.BaseDao;
import com.yy.entity.SysMailTemplateEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 邮件模板
 * @author shelei
 */
@Mapper
public interface SysMailTemplateDao extends BaseDao<SysMailTemplateEntity> {
	
}
