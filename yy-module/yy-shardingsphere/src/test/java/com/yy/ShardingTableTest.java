package com.yy;

import com.yy.dao.UserLogDao;
import com.yy.entity.UserLogEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 测试 ShardingSphere 分表
 *
 * @author shelei
 */
@SpringBootTest
public class ShardingTableTest {
    @Resource
    private UserLogDao userLogDao;

    @Test
    public void shardingTest() {
        UserLogEntity log = new UserLogEntity();
        //log.setId(1L);
        log.setName("test");
        log.setContent("测试");
        log.setCreateTime(LocalDateTime.now());

        userLogDao.insert(log);
    }
}
