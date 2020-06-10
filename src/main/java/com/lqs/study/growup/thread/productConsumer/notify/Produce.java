package com.lqs.study.growup.thread.productConsumer.notify;

/**
 * @program: grow-up
 * @description: 生产者
 * @author:luqinshun
 * @create: 2020-06-09 12:55
 **/
public class Produce implements Runnable {
    private Storage storage;

    public Produce(Storage storage) {
        this.storage=storage;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10);
                storage.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
