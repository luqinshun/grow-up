package com.lqs.study.growup.designpattern.singleton;

/**
 * @program: grow-up
 * @description:
 * @author:luqinshun
 * @create: 2020-05-28 20:34
 **/
public class SingletonTest {
    public static void main(String[] args) {
        //枚举的方式实现单例模式的调用
        EnumSingleton.ENUM_SINGLETON.doSomething();
    }
}
