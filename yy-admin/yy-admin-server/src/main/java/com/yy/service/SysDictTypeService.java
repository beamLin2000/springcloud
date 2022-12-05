package com.yy.service;

import com.yy.commons.mybatis.service.BaseService;
import com.yy.commons.tools.page.PageData;
import com.yy.dto.SysDictTypeDTO;
import com.yy.entity.DictType;
import com.yy.entity.SysDictTypeEntity;

import java.util.List;
import java.util.Map;

/**
 * 数据字典
 *
 * @author shelei
 */
public interface SysDictTypeService extends BaseService<SysDictTypeEntity> {

    PageData<SysDictTypeDTO> page(Map<String, Object> params);

    SysDictTypeDTO get(Long id);

    void save(SysDictTypeDTO dto);

    void update(SysDictTypeDTO dto);

    void delete(Long[] ids);

    /**
     * 获取所有字典
     */
    List<DictType> getAllList();

    /**
     * 字典类型列表
     */
    List<DictType> getDictTypeList();

}