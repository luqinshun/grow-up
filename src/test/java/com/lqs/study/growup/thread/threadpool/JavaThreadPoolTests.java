package com.lqs.study.growup.thread.threadpool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: grow-up
 * @description: java手动创建线程池测试
 * @author:luqinshun
 * @create: 2019-11-15 16:23
 **/
public class JavaThreadPoolTests {

    /**
     *
     * 结果：
     * 线程名称：pool-1-thread-1
     * 线程名称：pool-1-thread-2
     * 线程名称：pool-1-thread-3
     * 线程名称：pool-1-thread-4
     * 线程名称：pool-1-thread-7
     * 线程名称：pool-1-thread-8
     * 线程名称：pool-1-thread-5
     * 线程名称：pool-1-thread-6
     * 线程名称：pool-1-thread-9
     */
    @Test
    public void createThreadTest(){
        JavaThreadPool javaThreadPool = new JavaThreadPool();
        ThreadPoolExecutor threadPool = javaThreadPool.createThreadPool();
        for(int i=0;i<20;i++){
            threadPool.submit(()->{
                String name = Thread.currentThread().getName();
                System.out.println("线程名称："+ name);
            });
        }
    }

    /**
     * 线程名称：pool-1-thread-2
     * 线程名称：pool-1-thread-3
     * 线程名称：pool-1-thread-1
     * 线程名称：pool-1-thread-4
     * 线程名称：pool-1-thread-5
     * 线程名称：pool-1-thread-6
     * 线程名称：pool-1-thread-7
     * 线程名称：pool-1-thread-8
     * 线程名称：pool-1-thread-1
     * 线程名称：pool-1-thread-2
     * 线程名称：pool-1-thread-3
     * 线程名称：pool-1-thread-9
     * 线程名称：pool-1-thread-11
     * 线程名称：pool-1-thread-7
     * 线程名称：pool-1-thread-6
     * 线程名称：pool-1-thread-12
     * 线程名称：pool-1-thread-5
     * 线程名称：pool-1-thread-10
     * 线程名称：pool-1-thread-2
     * 线程名称：pool-1-thread-13
     */
    @Test
    public void createThreadPool1Test(){
        ThreadPoolExecutor threadPool = new JavaThreadPool().createThreadPool1();
        for(int i=0;i<20;i++){
            threadPool.submit(()->{
                String name = Thread.currentThread().getName();
                System.out.println("线程名称："+ name);
            });
        }
    }

    /**
     * 线程名称： pool-1-thread-1
     * 线程名称： pool-1-thread-3
     * 线程名称： pool-1-thread-2
     * 线程名称： pool-1-thread-4
     * 线程名称： pool-1-thread-5
     * 线程名称： pool-1-thread-6
     * 线程名称： pool-1-thread-7
     * 线程名称： pool-1-thread-1
     * 线程名称： pool-1-thread-5
     * 线程名称： pool-1-thread-3
     * 线程名称： pool-1-thread-6
     * 线程名称： pool-1-thread-2
     * 线程名称： pool-1-thread-7
     * 线程名称： pool-1-thread-8
     * 线程名称： pool-1-thread-5
     * 线程名称： pool-1-thread-3
     * 线程名称： pool-1-thread-9
     * 线程名称： pool-1-thread-1
     * 线程名称： pool-1-thread-4
     * 线程名称： pool-1-thread-2
     */
    @Test
    public void createCacheThreadPoolTest(){
        ThreadPoolExecutor cacheThreadPool = new JavaThreadPool().createCacheThreadPool();
        for(int i=0;i<20;i++){
            cacheThreadPool.submit(()->{
                String name = Thread.currentThread().getName();
                System.out.println("线程名称： "+ name);
            });

        }
    }
}
