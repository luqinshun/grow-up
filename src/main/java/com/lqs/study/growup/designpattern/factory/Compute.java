package com.lqs.study.growup.designpattern.factory;

/**
 * @program: grow-up
 * @description: 电脑
 * @author:luqinshun
 * @create: 2020-05-28 12:36
 **/
public class Compute implements Product {
    @Override
    public void make() {
        System.out.println("------智能电脑------");
    }
}
