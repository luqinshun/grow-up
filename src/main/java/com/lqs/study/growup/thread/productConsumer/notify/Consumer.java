package com.lqs.study.growup.thread.productConsumer.notify;

/**
 * @program: grow-up
 * @description: 消费者
 * @author:luqinshun
 * @create: 2020-06-09 12:57
 **/
public class Consumer implements Runnable {

    private Storage storage;

    public Consumer(Storage storage) {
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
