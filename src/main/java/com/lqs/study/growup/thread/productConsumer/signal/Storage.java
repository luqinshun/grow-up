package com.lqs.study.growup.thread.productConsumer.signal;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: grow-up
 * @description: 基于await/signal方式实现生产者和消费者模式
 * @author:luqinshun
 * @create: 2020-06-10 12:24
 **/
public class Storage {

    /**
     * 最大长度
     */
    private final static int MAX_SIZE= 10;

    /**
     * 存储数据
     */
    private LinkedList<Object> storeList=new LinkedList<>();

    /**
     * 实现锁
     */
    private final ReentrantLock lock=new ReentrantLock();

    /**
     * 满的状态
     */
    private final Condition full=lock.newCondition();

    /**
     * 空的状态
     */
    private final Condition empty=lock.newCondition();

    public void produce(){
        lock.lock();
        try {
            if(storeList.size()+1>MAX_SIZE){
                try {
                    full.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storeList.add(new Object());
            empty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void consumer(){
        lock.lock();
        try{
            if(storeList.size()==0){
                try {
                    empty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storeList.pop();
            full.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
