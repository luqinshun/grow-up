package com.lqs.study.growup.distribute.lock.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @program: grow-up
 * @description: 基于Curator封装的zookeeper分布式锁实现
 * @author:luqinshun
 * @create: 2019-11-29 16:27
 **/
public class CuratorZookeeperLock {

    public static void main(String[] args) {
        String zookeeperUrl="";
        //设置重试次数
        ExponentialBackoffRetry retry = new ExponentialBackoffRetry(1000, 3);
        // Zookeeper客户端创建
        CuratorFramework client = CuratorFrameworkFactory.newClient(zookeeperUrl, retry);
        //启动ZK
        client.start();

        //分布式锁的相关处理
        String rootPath="/lock";
        InterProcessMutex interProcessMutex = new InterProcessMutex(client, rootPath);
        //interProcessMutex.acquire();
        try {
            interProcessMutex.acquire();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                interProcessMutex.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
