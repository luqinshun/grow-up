package com.lqs.study.growup.thread.productConsumer.semaphore;


import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * @program: grow-up
 * @description: 信号量方式 实现生产者和消费者
 * @author:luqinshun
 * @create: 2020-06-11 12:23
 **/
public class SemaphoreStorage {
    /**
     * 数据存储
     */
    private LinkedList<Object> storeList=new LinkedList<>();
    /**
     * 最大容量
     */
    private Semaphore notFull=new Semaphore(10);
    /**
     * 未满的时候
     */
    private Semaphore notEmpty=new Semaphore(0);

    private Semaphore mutex=new Semaphore(1);

    public void produce(){
        try {
            notFull.acquire();
            mutex.acquire();
            storeList.add(new Object());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mutex.release();
            notEmpty.release();
        }
    }

    public void consume(){
        try {
            notEmpty.acquire();
            mutex.acquire();
            storeList.pop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mutex.release();
            notFull.release();
        }
    }
}
