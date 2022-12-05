package com.yy.service;

import com.yy.commons.mybatis.service.BaseService;
import com.yy.commons.tools.page.PageData;
import com.yy.dto.SysUserDTO;
import com.yy.entity.SysUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户管理
 *
 * @author shelei
 * @since 1.0.0
 */
public interface SysUserService extends BaseService<SysUserEntity> {

    PageData<SysUserDTO> page(Map<String, Object> params);

    List<SysUserDTO> list(Map<String, Object> params);

    SysUserDTO get(Long id);

    SysUserDTO getByUsername(String username);

    void save(SysUserDTO dto);

    void update(SysUserDTO dto);
    void updateUserInfo(SysUserDTO dto);

    void delete(Long[] ids);

    /**
     * 修改密码
     * @param id           用户ID
     * @param newPassword  新密码
     */
    void updatePassword(Long id, String newPassword);

    /**
     * 根据部门ID，查询用户数
     */
    int getCountByDeptId(Long deptId);

    /**
     * 根据部门ID,查询用户ID列表
     */
    List<Long> getUserIdListByDeptId(List<Long> deptIdList);
}