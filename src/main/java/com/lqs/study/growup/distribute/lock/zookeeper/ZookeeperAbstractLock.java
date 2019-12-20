package com.lqs.study.growup.distribute.lock.zookeeper;

import org.I0Itec.zkclient.ZkClient;

import java.util.Optional;

/**
 * @program: grow-up
 * @description: Zookeeper 分布式锁抽象模板类
 * @author:luqinshun
 * @create: 2019-11-29 11:20
 **/
public abstract class ZookeeperAbstractLock implements ExtLock{
    private static final String ZOOKEEPER_URL="";

    protected ZkClient zkClient=new ZkClient(ZOOKEEPER_URL);

    protected String lockRoot="/gome/ipc/lock";

    /**
     * 等待锁
     * @param businessKey
     */
    abstract void waitLock(String businessKey);

    /**
     * 尝试获取到锁
     * @param businessKey
     */
    abstract boolean tryLock(String businessKey);
    /**
     * 获取到锁
     */
    @Override
    public void getLock(String businessKey) {
        if(tryLock(businessKey)){
            //获取到锁
        }else{
            //锁等待
            waitLock(businessKey);
        }
    }

    /**
     * 释放锁
     */
    @Override
    public void unLock(String businessKey) {
        if(Optional.ofNullable(zkClient).isPresent()){
            zkClient.close();
        }
    }
}
