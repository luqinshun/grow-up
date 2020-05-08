package com.lqs.study.growup.spi.jdkspi;

/**
 * @program: grow-up
 * @description:
 * @author:luqinshun
 * @create: 2020-05-08 10:17
 **/
public class MyHello implements IHello {
    @Override
    public void say() {
        System.out.println("JDK spi 实现");
    }
}
