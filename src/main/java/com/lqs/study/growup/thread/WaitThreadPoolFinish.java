package com.lqs.study.growup.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @program: grow-up
 * @description: 主线程等待线程池完毕
 * @author:luqinshun
 * @create: 2019-11-11 17:59
 **/
@Slf4j
public class WaitThreadPoolFinish {

    /**
     * 方式一：基于线程池关闭和执行完毕
     *   特点： 线程池执行一次就销毁掉了，线程池中的线程不能复用
     */
    public void theadWait(){
        int threadSize=10;
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(threadSize, threadSize, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        for(int i=0;i<10;i++){
            final int n=i;
            threadPool.execute(()->{
                try {
                    System.out.println("线程执行： "+n);
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        //等待线程完毕
        shutdownThreadPool(threadPool);
    }

    /**
     * 方式二：通过闭锁的方式实现线程池所有任务完毕
     *    特点： 线程池可以作为通用的，性能相对较好
     * @throws InterruptedException
     */
    public void countDownLatch() throws InterruptedException {
        int threadSize=10;
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(threadSize, threadSize, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        for(int i=0;i<threadSize;i++){
            final int n=i;
            threadPool.execute(()->{
                try {
                    System.out.println("线程执行： "+n);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
    }

    /**
     * 先关闭线程池，拒绝新加入的线程，线程池中的线程正常运行，不会被强制终止。
     * 空闲线程将率先被回收
     * @param threadPool
     */
    private void shutdownThreadPool(ExecutorService threadPool){

        threadPool.shutdown();
        int loopNum=60*10;
        for(int i=0;i<loopNum;i++){
            if(threadPool.isTerminated()){
                break;
            }else if(i==(loopNum-1)){
                // 线程超时
                break;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        }
    }
}
