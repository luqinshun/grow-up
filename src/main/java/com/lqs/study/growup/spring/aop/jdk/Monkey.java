package com.lqs.study.growup.spring.aop.jdk;

/**
 * @program: grow-up
 * @description:
 * @author:luqinshun
 * @create: 2020-04-10 15:00
 **/
public class Monkey implements Animal {
    @Override
    public void run() {
        System.out.println("喜欢在树上乱窜");
    }

    @Override
    public void eat() {
        System.out.println("吃香蕉");
    }
}
