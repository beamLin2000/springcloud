package com.gxa.common.utils;

/**
 * 错误编码，由5位数字组成，前2位为模块编码，后3位为业务编码
 * 10 0001
 * 10 用户模块
 * 0001 用户模块中的某个错误代号
 *
 * 20 0001
 * <p>
 * 如：10001（10代表系统模块，001代表业务代码）
 * </p>
 *
 * @author shelei
 * @since 1.0.0
 */
public interface ErrorCode {
    int INTERNAL_SERVER_ERROR = 500;
    int UNAUTHORIZED = 401;
    int FORBIDDEN = 403;
    int NOT_FOUND = 404;

    int NOT_NULL = 10001;
    int DB_RECORD_EXISTS = 10002;
    int PARAMS_GET_ERROR = 10003;
    int ACCOUNT_PASSWORD_ERROR = 10004;
    int ACCOUNT_DISABLE = 10005;
    int IDENTIFIER_NOT_NULL = 10006;
    int CAPTCHA_ERROR = 10007;
    int SUB_MENU_EXIST = 10008;
    int PASSWORD_ERROR = 10009;
    int ACCOUNT_NOT_EXIST = 10010;
    int SUPERIOR_DEPT_ERROR = 10011;
    int SUPERIOR_MENU_ERROR = 10012;
    int DATA_SCOPE_PARAMS_ERROR = 10013;
    int JSON_FORMAT_ERROR = 10016;
    int LOGIN_EXPIRED = 10017;
}
 