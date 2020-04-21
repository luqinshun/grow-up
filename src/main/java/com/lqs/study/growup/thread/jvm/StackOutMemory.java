package com.lqs.study.growup.thread.jvm;

/**
 * @program: grow-up
 * @description:
 * @author:luqinshun
 * @create: 2020-04-14 09:51
 **/

public class StackOutMemory {
    /**
     * Exception in thread "main" java.lang.StackOverflowError
     * @param args
     */
    public static void main(String[] args) {
        new StackOutMemory().test();

    }

    public void test(){
        try {
            Thread.sleep(1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test();
    }
}
