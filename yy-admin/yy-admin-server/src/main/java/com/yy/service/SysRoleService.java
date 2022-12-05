package com.yy.service;

import com.yy.commons.mybatis.service.BaseService;
import com.yy.commons.tools.page.PageData;
import com.yy.dto.SysRoleDTO;
import com.yy.entity.SysRoleEntity;

import java.util.List;
import java.util.Map;

/**
 * 角色管理
 *
 * @author shelei
 * @since 1.0.0
 */
public interface SysRoleService extends BaseService<SysRoleEntity> {

    PageData<SysRoleDTO> page(Map<String, Object> params);

    List<SysRoleDTO> list(Map<String, Object> params);

    SysRoleDTO get(Long id);

    void save(SysRoleDTO dto);

    void update(SysRoleDTO dto);

    void delete(Long[] ids);

}