package com.yy.redis;

import com.yy.commons.tools.redis.RedisKeys;
import com.yy.commons.tools.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 验证码Redis
 *
 * @author shelei
 * @since 1.0.0
 */
@Component
public class CaptchaRedis {
    /**
     * 验证码5分钟过期
     */
    private final static long EXPIRE = 60 * 5L;
    @Autowired
    private RedisUtils redisUtils;

    public void set(String uuid, String captcha){
        String key = RedisKeys.getLoginCaptchaKey(uuid);
        redisUtils.set(key, captcha, EXPIRE);
    }

    public String get(String uuid){
        String key = RedisKeys.getLoginCaptchaKey(uuid);
        String captcha = (String)redisUtils.get(key);

        //删除验证码
        if(captcha != null){
            redisUtils.delete(key);
        }

        return captcha;
    }
}