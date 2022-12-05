package com.yy.service;

import com.yy.commons.mybatis.service.CrudService;
import com.yy.commons.tools.page.PageData;
import com.yy.dto.SysNoticeDTO;
import com.yy.entity.SysNoticeEntity;

import java.util.Map;

/**
 * 通知管理
 * @author shelei
 */
public interface SysNoticeService extends CrudService<SysNoticeEntity, SysNoticeDTO> {

    /**
     * 获取被通知的用户
     */
    PageData<SysNoticeDTO> getNoticeUserPage(Map<String, Object> params);

    /**
     * 获取我的通知列表
     */
    PageData<SysNoticeDTO> getMyNoticePage(Map<String, Object> params);
}