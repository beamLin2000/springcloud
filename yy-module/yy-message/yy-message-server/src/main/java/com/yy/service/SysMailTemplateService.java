package com.yy.service;

import com.yy.commons.mybatis.service.CrudService;
import com.yy.entity.SysMailTemplateEntity;
import com.yy.dto.SysMailTemplateDTO;

/**
 * 邮件模板
 *
 * @author shelei
 */
public interface SysMailTemplateService extends CrudService<SysMailTemplateEntity, SysMailTemplateDTO> {

    /**
     * 发送邮件
     * @param id           邮件模板ID
     * @param mailTo       收件人
     * @param mailCc       抄送
     * @param params       模板参数
     */
    boolean sendMail(Long id, String mailTo, String mailCc, String params) throws Exception;
}