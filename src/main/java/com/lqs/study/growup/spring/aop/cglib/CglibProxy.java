package com.lqs.study.growup.spring.aop.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @program: grow-up
 * @description: cglib代理生成
 * @author:luqinshun
 * @create: 2020-04-10 10:46
 **/
public class CglibProxy {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"E:\\game");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dog.class);
        enhancer.setCallback(new MyMethodInterceptor());
        Dog dogProxy = (Dog) enhancer.create();
        dogProxy.eat();
    }
}
