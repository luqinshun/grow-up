package com.lqs.study.growup.spring.expand;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @program: grow-up
 * @description: 自定义 BeanPostProcess接口
 *     在Bean初始化前后所做的处理
 *     Spring 的 BeanPostProcessor扩展接口
 * @author:luqinshun
 * @create: 2019-11-28 16:07
 **/
@Component
@Slf4j
public class MyBeanPostProcess implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("BeanPostProcess 初始化之前的处理： "+ beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //log.info("BeanPostProcess初始化之后的处理： {}",beanName);
        return bean;
    }
}
