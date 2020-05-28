package com.lqs.study.growup.designpattern.factory;

/**
 * @program: grow-up
 * @description:
 * @author:luqinshun
 * @create: 2020-05-28 12:36
 **/
public class Mouse implements Product {
    @Override
    public void make() {
        System.out.println("======鼠标=====");
    }
}
