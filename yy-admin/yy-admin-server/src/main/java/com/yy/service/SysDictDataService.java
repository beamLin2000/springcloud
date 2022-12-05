package com.yy.service;

import com.yy.commons.mybatis.service.BaseService;
import com.yy.commons.tools.page.PageData;
import com.yy.dto.SysDictDataDTO;
import com.yy.entity.SysDictDataEntity;

import java.util.Map;

/**
 * 数据字典
 *
 * @author shelei
 */
public interface SysDictDataService extends BaseService<SysDictDataEntity> {

    PageData<SysDictDataDTO> page(Map<String, Object> params);

    SysDictDataDTO get(Long id);

    void save(SysDictDataDTO dto);

    void update(SysDictDataDTO dto);

    void delete(Long[] ids);

}