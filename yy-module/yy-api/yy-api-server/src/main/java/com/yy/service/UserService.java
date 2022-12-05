package com.yy.service;

import com.yy.commons.mybatis.service.BaseService;
import com.yy.dto.LoginDTO;
import com.yy.entity.UserEntity;

import java.util.Map;

/**
 * 用户
 * @author shelei
 */
public interface UserService extends BaseService<UserEntity> {

	UserEntity getByMobile(String mobile);

	UserEntity getUserByUserId(Long userId);

	/**
	 * 用户登录
	 * @param dto    登录表单
	 * @return        返回登录信息
	 */
	Map<String, Object> login(LoginDTO dto);
}
