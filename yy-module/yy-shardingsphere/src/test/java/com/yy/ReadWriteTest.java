package com.yy;

import com.yy.dao.UserDao;
import com.yy.entity.UserEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 测试 ShardingSphere 读写分离
 * @author shelei
 */
@SpringBootTest
public class ReadWriteTest {
    @Resource
    private UserDao userDao;

    @Test
    public void writeTest() {
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setUsername("111");
        user.setMobile("11112345678");
        user.setCreateTime(LocalDateTime.now());

        // 只会保存到write-ds数据源里面，生产环境需要做主从同步，不然read-ds数据源是读不到数据
        userDao.insert(user);
    }

    @Test
    public void readTest() {
        // 通过read-ds数据源读取数据
        UserEntity user = userDao.selectById(1L);

        // 如果存在，则打印出来
        if(user != null){
            System.out.println(ToStringBuilder.reflectionToString(user));
        }else {
            System.out.println("没有查询数据！");
        }

    }

}