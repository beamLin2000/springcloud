package com.yy.service;

import com.yy.commons.mybatis.service.CrudService;
import com.yy.entity.SysSmsEntity;
import com.yy.dto.SysSmsDTO;

/**
 * 短信
 *
 * @author shelei
 */
public interface SysSmsService extends CrudService<SysSmsEntity, SysSmsDTO> {

    /**
     * 发送短信
     * @param smsCode   短信编码
     * @param mobile   手机号
     * @param params   短信参数
     */
    void send(String smsCode, String mobile, String params);

    SysSmsEntity getBySmsCode(String smsCode);

}

