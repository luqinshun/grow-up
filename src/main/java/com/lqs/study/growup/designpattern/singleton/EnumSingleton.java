package com.lqs.study.growup.designpattern.singleton;

public enum EnumSingleton {
    ENUM_SINGLETON;

    public void doSomething(){
        System.out.println("枚举的方式实现单例模式");
    }
}
