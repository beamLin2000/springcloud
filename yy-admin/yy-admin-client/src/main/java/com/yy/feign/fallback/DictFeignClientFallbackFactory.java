
package com.yy.feign.fallback;

import com.yy.commons.tools.utils.Result;
import com.yy.feign.DictFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 字典接口 FallbackFactory
 *
 * @author shelei
 */
@Slf4j
@Component
public class DictFeignClientFallbackFactory implements FallbackFactory<DictFeignClient> {
    @Override
    public DictFeignClient create(Throwable throwable) {
        log.error("{}", throwable);
        return () -> new Result<>();
    }
}
