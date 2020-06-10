package com.lqs.study.growup.thread.productConsumer.signal;

/**
 * @program: grow-up
 * @description: await/signal 方式实现生产者
 * @author:luqinshun
 * @create: 2020-06-10 12:35
 **/
public class Produce implements Runnable {

    private Storage storage;

    Produce(Storage storage){
        this.storage=storage;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
                storage.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
