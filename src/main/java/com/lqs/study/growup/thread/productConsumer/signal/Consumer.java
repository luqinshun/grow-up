package com.lqs.study.growup.thread.productConsumer.signal;

/**
 * @program: grow-up
 * @description: await/signal 实现消费者
 * @author:luqinshun
 * @create: 2020-06-10 12:38
 **/
public class Consumer implements Runnable {
    private Storage storage;

    Consumer(Storage storage){
        this.storage=storage;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
                storage.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
