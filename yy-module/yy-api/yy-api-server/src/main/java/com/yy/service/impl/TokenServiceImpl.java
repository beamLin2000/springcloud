package com.yy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yy.commons.mybatis.service.impl.BaseServiceImpl;
import com.yy.entity.TokenEntity;
import com.yy.service.TokenService;
import com.yy.dao.TokenDao;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;


@Service
public class TokenServiceImpl extends BaseServiceImpl<TokenDao, TokenEntity> implements TokenService {
	/**
	 * 12小时后过期
	 */
	private final static int EXPIRE = 3600 * 12;

	@Override
	public TokenEntity getByToken(String token) {
		return baseDao.getByToken(token);
	}

	@Override
	public TokenEntity createToken(Long userId) {
		//当前时间
		Date now = new Date();
		//过期时间
		Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

		//用户token
		String token;

		//判断是否生成过token
		TokenEntity tokenEntity = baseDao.getByUserId(userId);
		if(tokenEntity == null){
			//生成一个token
			token = generateToken();

			tokenEntity = new TokenEntity();
			tokenEntity.setUserId(userId);
			tokenEntity.setToken(token);
			tokenEntity.setUpdateDate(now);
			tokenEntity.setExpireDate(expireTime);

			//保存token
			this.insert(tokenEntity);
		}else{
			//判断token是否过期
			if(tokenEntity.getExpireDate().getTime() < System.currentTimeMillis()){
				//token过期，重新生成token
				token = generateToken();
			}else {
				token = tokenEntity.getToken();
			}

			tokenEntity.setToken(token);
			tokenEntity.setUpdateDate(now);
			tokenEntity.setExpireDate(expireTime);

			//更新token
			this.updateById(tokenEntity);
		}

		return tokenEntity;
	}

	@Override
	public void expireToken(Long userId){
		Date now = new Date();

		TokenEntity tokenEntity = new TokenEntity();
		tokenEntity.setUpdateDate(now);
		tokenEntity.setExpireDate(now);

		QueryWrapper<TokenEntity> updateWrapper = new QueryWrapper<>();
		updateWrapper.eq("user_id", userId);
		this.update(tokenEntity, updateWrapper);
	}

	private String generateToken(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
