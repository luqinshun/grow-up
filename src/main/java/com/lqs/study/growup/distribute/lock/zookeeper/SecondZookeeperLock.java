package com.lqs.study.growup.distribute.lock.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @program: grow-up
 * @description: 第二种通过Zookeeper实现分布式锁的方式
 * @author:luqinshun
 * @create: 2019-11-29 14:49
 **/
@Slf4j
public class SecondZookeeperLock implements Lock {
    private CountDownLatch countDownLatch;

    private static final String ZOOKEEPER_URL = "";

    private static final String ROOT = "/LOCK";

    private ZkClient zkClient = new ZkClient(ZOOKEEPER_URL, 4000, 4000, new SerializableSerializer());

    private String currentPath;

    private String beforePath;

    SecondZookeeperLock() {
        //创建永久节点
        if (zkClient.exists(ROOT)) {
            zkClient.createPersistent(ROOT);
        }
    }

    @Override
    public void lock() {
        if(!tryLock()){
            //没有获取到锁
            waitLock();
            lock();
        }else{
            // 获取到锁
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        // 创建临时节点
        if (StringUtils.isEmpty(currentPath)) {
            currentPath = this.zkClient.createEphemeralSequential(ROOT + "/", "lock");
        }

        List<String> children = this.zkClient.getChildren(ROOT);
        Collections.sort(children);
        // 说明临时节点中最小
        if (Optional.ofNullable(currentPath).isPresent() && currentPath.equals(children.get(0))) {
            return true;
        } else {
            int i = Collections.binarySearch(children, currentPath.substring(6));
            beforePath = children.get(i - 1);
        }
        // 当前临时节点，是不是最小的
        return false;
    }

    /**
     * 等待锁的释放
     */
    private void waitLock(){
        IZkDataListener zkDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            /**
             * 节点被删除
             * @param s
             * @throws Exception
             */
            @Override
            public void handleDataDeleted(String s) throws Exception {
                countDownLatch.countDown();
            }
        };
        // 注册监听
        this.zkClient.subscribeDataChanges(beforePath,zkDataListener);
        // 等待完成
        if(zkClient.exists(beforePath)){
            countDownLatch=new CountDownLatch(1);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }


        this.zkClient.unsubscribeDataChanges(beforePath,zkDataListener);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        zkClient.delete(currentPath);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
