package com.yy.service.impl;

import com.yy.commons.mybatis.service.impl.BaseServiceImpl;
import com.yy.dao.SysLanguageDao;
import com.yy.entity.SysLanguageEntity;
import com.yy.service.SysLanguageService;
import org.springframework.stereotype.Service;

/**
 * 国际化
 *
 * @author shelei
 */
@Service
public class SysLanguageServiceImpl extends BaseServiceImpl<SysLanguageDao, SysLanguageEntity> implements SysLanguageService {

    @Override
    public void saveOrUpdate(String tableName, Long tableId, String fieldName, String fieldValue, String language) {
        SysLanguageEntity entity = new SysLanguageEntity();
        entity.setTableName(tableName);
        entity.setTableId(tableId);
        entity.setFieldName(fieldName);
        entity.setFieldValue(fieldValue);
        entity.setLanguage(language);

        //判断是否有数据
        if(baseDao.getLanguage(entity) == null){
            baseDao.insert(entity);
        }else {
            baseDao.updateLanguage(entity);
        }
    }
}