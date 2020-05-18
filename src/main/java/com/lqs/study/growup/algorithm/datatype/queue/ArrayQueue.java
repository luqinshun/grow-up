package com.lqs.study.growup.algorithm.datatype.queue;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: grow-up
 * @description: 数组实现队列
 * @author:luqinshun
 * @create: 2020-05-18 15:46
 **/
public class ArrayQueue<T> {
    private T[] container;

    private Integer size;

    private AtomicInteger start;

    private AtomicInteger end;

    ArrayQueue(Integer size){
        this.size=size;
        this.start=new AtomicInteger(0);
        this.end=new AtomicInteger(0);
        container=(T[]) new Object[size];
    }

    public void enquene(T t){
        int endIndex = end.intValue();
        container[endIndex]=t;
        //循环队列的处理,当数组到头
        int newEndIndex = (endIndex + 1) % size;
        if(start.intValue()==newEndIndex){
            //队列已经满了 可以抛出异常
        }
        end=new AtomicInteger(newEndIndex);
    }

    /**
     * 出队列
     */
    public T dequeue(){
        if(start.intValue()>=end.intValue()){
            return null;
        }
        int startIndex = start.incrementAndGet();
        T t = container[startIndex];
        start.incrementAndGet();
        return t;
    }
}
