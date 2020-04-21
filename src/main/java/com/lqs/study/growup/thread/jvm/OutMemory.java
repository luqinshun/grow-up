package com.lqs.study.growup.thread.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @program: grow-up
 * @description: 内存溢出测试
 * @author:luqinshun
 * @create: 2020-04-13 18:13
 **/
public class OutMemory {
    private static final String NEW_STR="数据";

    char[] chars=new char[1024*10];

    public static void main(String[] args) {
        synchronized (OutMemory.class){
            List allList=new ArrayList<>(12);
            while(true){
                OutMemory outMemory = new OutMemory();

                allList.add(outMemory);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
