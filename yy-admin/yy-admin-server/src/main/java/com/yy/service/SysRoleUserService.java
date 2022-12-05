package com.yy.service;

import com.yy.commons.mybatis.service.BaseService;
import com.yy.entity.SysRoleUserEntity;

import java.util.List;

/**
 * 角色用户关系
 *
 * @author shelei
 * @since 1.0.0
 */
public interface SysRoleUserService extends BaseService<SysRoleUserEntity> {

    /**
     * 保存或修改
     * @param userId      用户ID
     * @param roleIdList  角色ID列表
     */
    void saveOrUpdate(Long userId, List<Long> roleIdList);

    /**
     * 根据角色ids，删除角色用户关系
     * @param roleIds 角色ids
     */
    void deleteByRoleIds(Long[] roleIds);

    /**
     * 根据用户id，删除角色用户关系
     * @param userId 用户id
     */
    void deleteByUserId(Long userId);

    /**
     * 角色ID列表
     * @param userId  用户ID
     */
    List<Long> getRoleIdList(Long userId);
}