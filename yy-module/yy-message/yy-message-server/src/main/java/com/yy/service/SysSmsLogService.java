package com.yy.service;

import com.yy.commons.mybatis.service.CrudService;
import com.yy.dto.SysSmsLogDTO;
import com.yy.entity.SysSmsLogEntity;

import java.util.LinkedHashMap;

/**
 * 短信日志
 *
 * @author shelei
 */
public interface SysSmsLogService extends CrudService<SysSmsLogEntity, SysSmsLogDTO> {

    /**
     * 保存短信发送记录
     * @param smsCode   短信编码
     * @param platform  平台
     * @param mobile    手机号
     * @param params    短信参数
     * @param status    发送状态
     */
    void save(String smsCode, Integer platform, String mobile, LinkedHashMap<String, String> params, Integer status);
}