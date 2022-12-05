package com.yy.dao;

import com.yy.commons.mybatis.dao.BaseDao;
import com.yy.entity.ExcelDataEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* Excel导入演示
*
 * @author shelei
*/
@Mapper
public interface ExcelDataDao extends BaseDao<ExcelDataEntity> {
	
}