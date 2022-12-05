
package com.yy.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 演示xxl-job定时任务
 *
 * @author shelei
 */
@Slf4j
@Component
public class TestJob {
    /**
     * 任务示例
     */
    @XxlJob("testHandler")
    public ReturnT<String> testHandler(String param) throws Exception {
        log.info("xxl-job 正在执行，参数：{}", param);
        return ReturnT.SUCCESS;
    }
}
