package com.lqs.study.growup.thread.threadpool;

import java.util.concurrent.*;

/**
 * @program: grow-up
 * @description: jdk线程池创建方式
 * @author:luqinshun
 * @create: 2019-11-15 15:28
 **/
public class JavaThreadPool {

    /**
     * 创建无界队列 线程池
     * @return
     */
    public ThreadPoolExecutor createThreadPool(){
        int corePoolSize=200;
        int maxCorePoolSize=200;
        long keepLiveTime=0L;
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(corePoolSize,
                maxCorePoolSize,
                keepLiveTime,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
        return threadPool;
    }

    /**
     * 创建有界队列
     * @return
     */
    public ThreadPoolExecutor createThreadPool1(){
        int corePoolSize=10;
        int maxCorePoolSize=300;
        long keepLiveTime= 30*1000;
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(corePoolSize,
                maxCorePoolSize,
                keepLiveTime,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(2),
                new ThreadPoolExecutor.AbortPolicy());
        return threadPool;
    }

    /**
     * 缓存线程池，理论上是无限的，最大的容量是Integer.MAX_VALUE (2的31次方，21亿多)
     *
     * @return
     */
    public ThreadPoolExecutor createCacheThreadPool(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0,
                Integer.MAX_VALUE,
                60,
                TimeUnit.SECONDS,
                new SynchronousQueue<>());
        return threadPoolExecutor;
    }

    /**
     * 创建单个线程池
     * @return
     */
    public ThreadPoolExecutor createSingleThreadPool(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
                1,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
        return threadPoolExecutor;
    }
}
