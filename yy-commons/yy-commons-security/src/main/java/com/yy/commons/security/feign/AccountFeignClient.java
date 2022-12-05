package com.yy.commons.security.feign;

import com.yy.commons.security.user.UserDetail;
import com.yy.commons.tools.constant.ServiceConstant;
import com.yy.commons.tools.utils.Result;
import com.yy.commons.security.feign.fallback.AccountFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 账号接口
 *
 * @author shelei
 */
@FeignClient(name = ServiceConstant.YY_ADMIN_SERVER, contextId = "AccountFeignClient", fallbackFactory = AccountFeignClientFallbackFactory.class)
public interface AccountFeignClient {

    /**
     * 根据用户名，获取用户信息
     * @param username  用户名
     */
    @PostMapping("sys/user/getByUsername")
    Result<UserDetail> getByUsername(@RequestParam("username") String username);

}