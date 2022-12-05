
package com.yy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yy.commons.mybatis.service.impl.CrudServiceImpl;
import com.yy.dao.UReportDataDao;
import com.yy.dto.UReportDataDTO;
import com.yy.entity.UReportDataEntity;
import com.yy.service.UReportDataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class UReportDataServiceImpl extends CrudServiceImpl<UReportDataDao, UReportDataEntity, UReportDataDTO> implements UReportDataService {

    @Override
    public QueryWrapper<UReportDataEntity> getWrapper(Map<String, Object> params){
        String fileName = (String)params.get("fileName");

        QueryWrapper<UReportDataEntity> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(fileName), "file_name", fileName);
        return wrapper;
    }

}
