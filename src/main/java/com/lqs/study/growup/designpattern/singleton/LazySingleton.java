package com.lqs.study.growup.designpattern.singleton;

/**
 * @program: grow-up
 * @description: 饿汉式
 * @author:luqinshun
 * @create: 2020-05-28 20:14
 **/
public class LazySingleton {

    private static LazySingleton lazySingleton;

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        //使用双重锁校验，保证线程安全
        synchronized(LazySingleton.class){
            if(lazySingleton ==null){
                lazySingleton =new LazySingleton();
            }
        }
        return lazySingleton;
    }
}
