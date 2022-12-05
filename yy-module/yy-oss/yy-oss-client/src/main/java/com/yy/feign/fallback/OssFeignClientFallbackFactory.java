package com.yy.feign.fallback;

import com.yy.dto.UploadDTO;
import com.yy.feign.OssFeignClient;
import com.yy.commons.tools.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * OSS FallbackFactory
 *
 * @author shelei
 */
@Slf4j
@Component
public class OssFeignClientFallbackFactory implements FallbackFactory<OssFeignClient> {
    @Override
    public OssFeignClient create(Throwable throwable) {
        log.error("{}", throwable);

        return file -> new Result<UploadDTO>().error();
    }
}
