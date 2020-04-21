package com.lqs.study.growup.spring.aop.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: grow-up
 * @description: 方法拦截器
 * @author:luqinshun
 * @create: 2020-04-10 10:42
 **/
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("加一点孜然");
        return methodProxy.invokeSuper(o,objects);
    }
}
