package com.lqs.study.growup.designpattern.singleton;

/**
 * @program: grow-up
 * @description: 使用内部类实现单例的方式
 * @author:luqinshun
 * @create: 2020-05-28 20:21
 **/
public class InnerSingleton {
    /**
     * 依托静态内部类实现
     * 好处是： 外部类如果不加在，内部类是不会加载的，所有节省了内存
     */
    static class InnerClass{
        static InnerSingleton INNER_SINGLETON=new InnerSingleton();
    }

    private InnerSingleton(){}

    public static InnerSingleton getInstance(){
        return InnerClass.INNER_SINGLETON;
    }
}
