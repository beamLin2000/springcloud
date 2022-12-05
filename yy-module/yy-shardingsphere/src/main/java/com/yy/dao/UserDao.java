package com.yy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.yy.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * 用户
 *
 * @author shelei
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {


}