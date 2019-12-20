package com.lqs.study.growup.distribute.lock.zookeeper;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;

/**
 * @program: grow-up
 * @description: 通过Zookeeper实现分布式锁
 * @author:luqinshun
 * @create: 2019-11-29 10:58
 **/
public class ZookeeperLock extends ZookeeperAbstractLock{
    protected CountDownLatch countDownLatch=null;
    /**
     * 等待锁
     * @param businessKey
     */
    @Override
    void waitLock(String businessKey) {
        String path=lockRoot+"/"+businessKey;
        IZkDataListener zkDataListener = new IZkDataListener() {
            /**
             * 节点发生修改
             * @param s
             * @param o
             * @throws Exception
             */
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                if(countDownLatch!=null){
                    countDownLatch.countDown();
                }
            }

            /**
             * 节点被删除
             * @param s
             * @throws Exception
             */
            @Override
            public void handleDataDeleted(String s) throws Exception {

            }
        };

        //监听Zk 节点变化的注入
        zkClient.subscribeDataChanges(path,zkDataListener);
        if(zkClient.exists(path)){
            countDownLatch=new CountDownLatch(1);
            try {
                //等待时间事件完毕
                countDownLatch.await();
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
        //删除事件监听，不影响后续的任务
        zkClient.unsubscribeDataChanges(path,zkDataListener);

    }

    /**
     * 尝试获取到锁
     * @param businessKey
     */
    @Override
    boolean tryLock(String businessKey) {
        try {
            zkClient.createEphemeral(lockRoot+"/"+businessKey);
            return true;
        } catch (RuntimeException e) {
            //e.printStackTrace();
            // 未获取到锁资源
        }
        return false;
    }
}
