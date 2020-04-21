package com.lqs.study.growup.spring.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: grow-up
 * @description:
 * @author:luqinshun
 * @create: 2020-04-10 15:01
 **/
public class AnimalProxy implements InvocationHandler {
    private Object target;

    public AnimalProxy(Object target){
        this.target=target;
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("放归自然。。。");
        Object invoke = method.invoke(target, args);
        System.out.println("悠然自得。。。");
        return invoke;
    }

    public Object createProxyObj(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
