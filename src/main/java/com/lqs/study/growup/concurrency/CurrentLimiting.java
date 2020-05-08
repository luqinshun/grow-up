package com.lqs.study.growup.concurrency;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.Semaphore;

/**
 * @program: grow-up
 * @description: 高并发限流的处理方案，方便的工具类实现方式
 * @author:luqinshun
 * @create: 2020-04-23 17:35
 **/
public class CurrentLimiting {
    /**
     * 方案一： 信号量的实现方式
     *
     */
    private Semaphore semaphore=new Semaphore(10);

    public void semaphoreLimiting(){
        /**
         * 如果信号量中的长度大于20，可以单独处理
         */
        if(semaphore.getQueueLength()>20){
            // doSomething... 返回排队信息处理
        }
        boolean flag=false;
        try {
            flag=semaphore.tryAcquire();
            if(flag){
                //doSomething....
            }
        } finally {
            if(flag){
                semaphore.release();
            }

        }
    }

    /**
     * 方案二： 令牌桶的方式实现限流
     */
    private RateLimiter rateLimiter=RateLimiter.create(2);
    public void woodenTokenLimiting(){
        if(!rateLimiter.tryAcquire()){
            System.out.println("限流中");
        }
        //正常运行
        // doSomething()...
    }

}
