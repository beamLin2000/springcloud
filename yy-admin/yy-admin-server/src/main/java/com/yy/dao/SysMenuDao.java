package com.yy.dao;

import com.yy.commons.mybatis.dao.BaseDao;
import com.yy.entity.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单管理
 *
 * @author shelei
 * @since 1.0.0
 */
@Mapper
public interface SysMenuDao extends BaseDao<SysMenuEntity> {

    SysMenuEntity getById(@Param("id") Long id, @Param("language") String language);

    /**
     * 查询所有菜单列表
     *
     * @param menuType 菜单类型
     * @param language 语言
     */
    List<SysMenuEntity> getMenuList(@Param("menuType") Integer menuType, @Param("language") String language);

    /**
     * 查询用户菜单列表
     *
     * @param userId 用户ＩＤ
     * @param menuType 菜单类型
     * @param language 语言
     */
    List<SysMenuEntity> getUserMenuList(@Param("userId") Long userId, @Param("menuType") Integer menuType, @Param("language") String language);


    /**
     * 根据父菜单，查询子菜单
     * @param pid  父菜单ID
     */
    List<SysMenuEntity> getListPid(Long pid);
}