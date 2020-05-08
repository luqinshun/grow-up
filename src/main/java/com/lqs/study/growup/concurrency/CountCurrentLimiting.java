package com.lqs.study.growup.concurrency;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: grow-up
 * @description: 计数器方式实现限流—— 漏桶算法 —— 低窗口的实现
 * @author:luqinshun
 * @create: 2020-04-24 10:35
 **/
public class CountCurrentLimiting {
    private final static AtomicLong ZERO=new AtomicLong(0);

    private AtomicLong count=ZERO;
    /**
     * 记录时间戳，并发限流的时候动态更新
     */
    private long timestamp=System.currentTimeMillis();

    private long permitsPerSecond;

    CountCurrentLimiting(long permitsPerSecond){
        this.permitsPerSecond=permitsPerSecond;
    }

    /**
     *
     * @return
     */
    public boolean tryAcquire(){
        long now = System.currentTimeMillis();
        if((now-timestamp)<1000){
            // 获取到之后，通过自增的方式
           if(count.get()<permitsPerSecond){
               //可以修改为Redis方式的自增id，实现限流的方式
               count.incrementAndGet();
               return true;
           }else{
               return false;
           }
        }else {
            //重记计数窗口，重置的时期，可能会有高并发
            count=ZERO;
            timestamp=now;
            return false;
        }
    }
}
