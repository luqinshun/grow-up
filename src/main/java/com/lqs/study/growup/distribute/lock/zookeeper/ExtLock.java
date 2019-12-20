package com.lqs.study.growup.distribute.lock.zookeeper;

/**
 * @author luqinshun
 */
public interface ExtLock {
    /**
     * 获取到锁
     */
    void getLock(String businessKey);

    /**
     * 释放锁
     */
    void unLock(String businessKey);
}
