package com.yy.commons.lock.aop;

import com.yy.commons.lock.LockInfo;
import com.yy.commons.lock.LockKeyGenerator;
import com.yy.commons.lock.annotation.Lock4j;
import com.yy.commons.lock.LockTemplate;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 分布式锁aop处理器
 *
 * @author shelei
 */
@Slf4j
public class LockInterceptor implements MethodInterceptor {
    @Setter
    private LockTemplate lockTemplate;

    private LockKeyGenerator lockKeyGenerator = new LockKeyGenerator();

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        LockInfo lockInfo = null;
        try {
            Lock4j lock4j = invocation.getMethod().getAnnotation(Lock4j.class);
            String keyName = lockKeyGenerator.getKeyName(invocation, lock4j);
            lockInfo = lockTemplate.lock(keyName, lock4j.expire(), lock4j.timeout());
            if (null != lockInfo) {
                return invocation.proceed();
            }
            return null;
        } finally {
            if (null != lockInfo) {
                lockTemplate.releaseLock(lockInfo);
            }
        }
    }

}
