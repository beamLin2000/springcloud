package com.yy.commons.security.feign.fallback;

import com.yy.commons.security.feign.AccountFeignClient;
import com.yy.commons.tools.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 账号接口 FallbackFactory
 *
 * @author shelei
 */
@Slf4j
@Component
public class AccountFeignClientFallbackFactory implements FallbackFactory<AccountFeignClient> {
    @Override
    public AccountFeignClient create(Throwable throwable) {
        log.error("{}", throwable);

        return username -> new Result<>();
    }
}
