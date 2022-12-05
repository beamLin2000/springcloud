package com.yy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yy.entity.UserLogEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * 用户日志
 *
 * @author shelei
 */
@Mapper
public interface UserLogDao extends BaseMapper<UserLogEntity> {


}