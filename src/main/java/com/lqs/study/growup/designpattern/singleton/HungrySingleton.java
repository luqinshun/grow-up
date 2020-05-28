package com.lqs.study.growup.designpattern.singleton;

/**
 * @program: grow-up
 * @description: 懒汉式
 * @author:luqinshun
 * @create: 2020-05-28 20:20
 **/
public class HungrySingleton {
    private static HungrySingleton hungrySingleton =new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
