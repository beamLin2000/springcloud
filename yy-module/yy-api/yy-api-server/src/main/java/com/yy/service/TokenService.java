package com.yy.service;

import com.yy.commons.mybatis.service.BaseService;
import com.yy.entity.TokenEntity;

/**
 * 用户Token
 *
 * @author shelei
 */
public interface TokenService extends BaseService<TokenEntity> {

	TokenEntity getByToken(String token);

	/**
	 * 生成token
	 * @param userId  用户ID
	 * @return        返回token信息
	 */
	TokenEntity createToken(Long userId);

	/**
	 * 设置token过期
	 * @param userId 用户ID
	 */
	void expireToken(Long userId);

}
