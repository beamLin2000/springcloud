package com.yy.exception;

import com.yy.commons.tools.exception.ErrorCode;
import com.yy.commons.tools.exception.YYException;
import com.yy.commons.tools.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 异常处理器
 *
 * @author shelei
 * @since 1.0.0
 */
@RestControllerAdvice
public class YYExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(YYExceptionHandler.class);

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(YYException.class)
	public Result handleRRException(YYException ex){
		Result result = new Result();
		result.error(ex.getCode(), ex.getMsg());

		return result;
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public Result handleDuplicateKeyException(DuplicateKeyException ex){
		Result result = new Result();
		result.error(ErrorCode.DB_RECORD_EXISTS);

		return result;
	}


	@ExceptionHandler(AccessDeniedException.class)
	public Result handleAccessDeniedException(Exception ex){
		Result result = new Result();
		result.error(ErrorCode.FORBIDDEN);

		return result;
	}

	@ExceptionHandler(Exception.class)
	public Result handleException(Exception ex){
		logger.error(ex.getMessage(), ex);

		return new Result().error();
	}
}