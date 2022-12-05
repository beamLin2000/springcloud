package com.yy.exception;

import com.yy.commons.tools.exception.ErrorCode;

/**
 * 模块错误编码，由9位数字组成，前6位为模块编码，后3位为业务编码
 * <p>
 * 如：100001001（100001代表模块，001代表业务代码）
 * </p>
 *
 * @author shelei
 * @since 1.0.0
 */
public interface ModuleErrorCode extends ErrorCode {
    int TOKEN_NOT_EMPTY = 100005001;
    int TOKEN_INVALID = 100005002;
}
