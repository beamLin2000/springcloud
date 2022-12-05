-- 短信
create table sys_sms
(
    id                   bigint NOT NULL COMMENT 'id',
    sms_code             varchar(32) COMMENT '短信编码',
    platform             tinyint unsigned NOT NULL COMMENT '平台类型',
    sms_config           varchar(2000) COMMENT '短信配置',
    remark               varchar(200) COMMENT '备注',
    creator              bigint COMMENT '创建者',
    create_date          datetime COMMENT '创建时间',
    updater              bigint COMMENT '更新者',
    update_date          datetime COMMENT '更新时间',
    primary key (id),
    unique key uk_sms_code (sms_code),
    key idx_create_date (create_date)
)ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COMMENT='短信';

-- 短信日志
CREATE TABLE sys_sms_log (
    id bigint NOT NULL COMMENT 'id',
    sms_code varchar(32) COMMENT '短信编码',
    platform tinyint unsigned NOT NULL COMMENT '平台类型',
    mobile varchar(20) COMMENT '手机号',
    params_1 varchar(50) COMMENT '参数1',
    params_2 varchar(50) COMMENT '参数2',
    params_3 varchar(50) COMMENT '参数3',
    params_4 varchar(50) COMMENT '参数4',
    status tinyint unsigned COMMENT '发送状态  0：失败  1：成功',
    creator bigint COMMENT '创建者',
    create_date datetime COMMENT '创建时间',
    PRIMARY KEY (id),
    key idx_sms_code (sms_code)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COMMENT='短信日志';


-- 邮件模板
CREATE TABLE sys_mail_template (
  id bigint NOT NULL COMMENT 'id',
  name varchar(100) COMMENT '模板名称',
  subject varchar(200) COMMENT '邮件主题',
  content text COMMENT '邮件正文',
  creator bigint COMMENT '创建者',
  create_date datetime COMMENT '创建时间',
  updater bigint COMMENT '更新者',
  update_date datetime COMMENT '更新时间',
  PRIMARY KEY (id),
  key idx_create_date (create_date)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8 COMMENT='邮件模板';


-- 邮件发送记录
CREATE TABLE sys_mail_log (
  id bigint NOT NULL COMMENT 'id',
  template_id bigint NOT NULL COMMENT '邮件模板ID',
  mail_from varchar(200) COMMENT '发送者',
  mail_to varchar(400) COMMENT '收件人',
  mail_cc varchar(400) COMMENT '抄送者',
  subject varchar(200) COMMENT '邮件主题',
  content text COMMENT '邮件正文',
  status tinyint unsigned COMMENT '发送状态  0：失败  1：成功',
  creator bigint COMMENT '创建者',
  create_date datetime COMMENT '创建时间',
  PRIMARY KEY (id),
  key idx_create_date (create_date)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8 COMMENT='邮件发送记录';

INSERT INTO sys_params(id, param_code, param_value, param_type, remark, del_flag, creator, create_date, updater, update_date) VALUES (1067246875800000145, 'MAIL_CONFIG_KEY', '{"smtp":"smtp.163.com","port":25,"username":"xxx@163.com","password":"123456"}', 0, '邮件配置信息', 0, 1067246875800000001, now(), 1067246875800000001, now());

INSERT INTO sys_mail_template(id, name, subject, content, create_date) VALUES (1067246875800000147, '验证码模板', '注册验证码', '<p>yy注册验证码：${code}</p>', now());

INSERT INTO sys_sms(id, sms_code, platform, sms_config, remark, creator, create_date, updater, update_date) VALUES (1228954061084676097, '1001', 1, '{"aliyunAccessKeyId":"1","aliyunAccessKeySecret":"1","aliyunSignName":"1","aliyunTemplateCode":"1","qcloudAppKey":"","qcloudSignName":"","qcloudTemplateId":"","qiniuAccessKey":"","qiniuSecretKey":"","qiniuTemplateId":""}', '', 1067246875800000001, now(), 1067246875800000001, now());

INSERT INTO sys_menu(id, pid, url, open_style, menu_type, icon, permissions, sort, del_flag, creator, create_date, updater, update_date) VALUES (1067246875800000056, 0, '', 0, 0, 'icon-message', '', 3, 0, 1067246875800000001, now(), 1067246875800000001, now());
INSERT INTO sys_menu(id, pid, url, open_style, menu_type, icon, permissions, sort, del_flag, creator, create_date, updater, update_date) VALUES (1067246875800000057, 1067246875800000056, 'message/sms', 0, 0, 'icon-layout', 'sys:sms:all', 0, 0, 1067246875800000001, now(), 1067246875800000001, now());
INSERT INTO sys_menu(id, pid, url, open_style, menu_type, icon, permissions, sort, del_flag, creator, create_date, updater, update_date) VALUES (1067246875800000058, 1067246875800000056, 'message/mail-template', 0, 0, 'icon-appstore', 'sys:mail:all', 1, 0, 1067246875800000001, now(), 1067246875800000001, now());
INSERT INTO sys_menu(id, pid, url, open_style, menu_type, icon, permissions, sort, del_flag, creator, create_date, updater, update_date) VALUES (1067246875800000059, 1067246875800000056, 'message/mail-log', 0, 0, 'icon-save', 'sys:mail:log', 2, 0, 1067246875800000001, now(), 1067246875800000001, now());
INSERT INTO sys_menu(id, pid, url, open_style, menu_type, icon, permissions, sort, del_flag, creator, create_date, updater, update_date) VALUES (1067246875800000301, 1067246875800000056, 'message/sms-log', 0, 0, 'icon-layout', 'sys:smslog:all', 1, 0, 1067246875800000001, now(), 1067246875800000001, now());

INSERT INTO sys_language(table_name, table_id, field_name, field_value, language) VALUES ('sys_menu', 1067246875800000056, 'name', 'Message Management', 'en-US');
INSERT INTO sys_language(table_name, table_id, field_name, field_value, language) VALUES ('sys_menu', 1067246875800000056, 'name', '消息管理', 'zh-CN');
INSERT INTO sys_language(table_name, table_id, field_name, field_value, language) VALUES ('sys_menu', 1067246875800000056, 'name', '消息管理', 'zh-TW');
INSERT INTO sys_language(table_name, table_id, field_name, field_value, language) VALUES ('sys_menu', 1067246875800000057, 'name', 'SMS Service', 'en-US');
INSERT INTO sys_language(table_name, table_id, field_name, field_value, language) VALUES ('sys_menu', 1067246875800000057, 'name', '短信服务', 'zh-CN');
INSERT INTO sys_language(table_name, table_id, field_name, field_value, language) VALUES ('sys_menu', 1067246875800000057, 'name', '短信服務', 'zh-TW');
INSERT INTO sys_language(table_name, table_id, field_name, field_value, language) VALUES ('sys_menu', 1067246875800000058, 'name', 'Mail Template', 'en-US');
INSERT INTO sys_language(table_name, table_id, field_name, field_value, language) VALUES ('sys_menu', 1067246875800000058, 'name', '邮件模板', 'zh-CN');
INSERT INTO sys_language(table_name, table_id, field_name, field_value, language) VALUES ('sys_menu', 1067246875800000058, 'name', '郵件模板', 'zh-TW');
INSERT INTO sys_language(table_name, table_id, field_name, field_value, language) VALUES ('sys_menu', 1067246875800000059, 'name', 'Mail Log', 'en-US');
INSERT INTO sys_language(table_name, table_id, field_name, field_value, language) VALUES ('sys_menu', 1067246875800000059, 'name', '邮件发送记录', 'zh-CN');
INSERT INTO sys_language(table_name, table_id, field_name, field_value, language) VALUES ('sys_menu', 1067246875800000059, 'name', '郵件發送記錄', 'zh-TW ');
INSERT INTO sys_language(table_name, table_id, field_name, field_value, language) VALUES ('sys_menu', 1067246875800000301, 'name', 'SMS History', 'en-US');
INSERT INTO sys_language(table_name, table_id, field_name, field_value, language) VALUES ('sys_menu', 1067246875800000301, 'name', '短信发送记录', 'zh-CN');
INSERT INTO sys_language(table_name, table_id, field_name, field_value, language) VALUES ('sys_menu', 1067246875800000301, 'name', '短信發送記錄', 'zh-TW');

