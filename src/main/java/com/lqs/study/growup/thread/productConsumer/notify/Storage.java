package com.lqs.study.growup.thread.productConsumer.notify;


import java.util.LinkedList;
import java.util.List;

/**
 * @program: grow-up
 * @description: 生产者与消费者的存储
 * @author:luqinshun
 * @create: 2020-06-09 12:41
 **/
public class Storage {
    /**
     * 存储数据任务容器
     */
    private LinkedList<Object> storeList=new LinkedList<Object>();
    /**
     * 容器最大容量
     */
    private static int MAX_SIZE=10;

    public void produce(){
        synchronized (storeList){
            // 线程满的时候，线程处于等待状态
            while((storeList.size()+1)>MAX_SIZE){
                try {
                    storeList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 生产商品
            storeList.add(new Object());
            // 并唤醒等待的所有线程
            storeList.notifyAll();
        }
    }

    public void consumer(){
        synchronized (storeList){
            while (storeList.size()==0){
                try {
                    storeList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //弹出第一个数据
            storeList.pop();
            // 唤醒线程
            storeList.notifyAll();
        }
    }
}
