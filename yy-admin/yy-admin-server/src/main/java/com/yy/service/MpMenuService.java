package com.yy.service;


import com.yy.commons.mybatis.service.CrudService;
import com.yy.dto.MpMenuDTO;
import com.yy.entity.MpMenuEntity;

/**
 * 公众号自定义菜单
 *
 * @author shelei
 */
public interface MpMenuService extends CrudService<MpMenuEntity, MpMenuDTO> {

    MpMenuDTO getByAppId(String appId);

    void deleteByAppId(String appId);
}