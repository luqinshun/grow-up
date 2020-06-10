package com.lqs.study.growup.thread.productConsumer.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: grow-up
 * @description: 通过阻塞队列实现生产者和消费者
 * @author:luqinshun
 * @create: 2020-06-10 12:41
 **/
public class QueueStorage {

    private LinkedBlockingQueue<Object> storage=new LinkedBlockingQueue<>();

    public void produce(){
        try {
            storage.put(new Object());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consumer(){
        try {
            storage.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
