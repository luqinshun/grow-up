package com.lqs.study.growup.spring.aop.cglib;

/**
 * @program: grow-up
 * @description: 代理对象
 * @author:luqinshun
 * @create: 2020-04-10 10:40
 **/
public class Dog {
    final public void run(){
        System.out.println("run... 奔跑吧 ，小黄");
    }

    public void eat(){
        System.out.println("嘎嘣脆的骨头");
    }
}
