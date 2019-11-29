package com.lqs.study.growup.spring.expand;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @program: grow-up
 * @description: 基于ApplicationContextAware提供 Spring的工具类
 *        Spring的 ApplicationContextAware 扩展接口
 * @author:luqinshun
 * @create: 2019-11-28 16:17
 **/
@Component
public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringUtil.applicationContext==null){
            SpringUtil.applicationContext=applicationContext;
        }
    }

    /**
     * 获取到当前的ApplicationContext对象
     * @return
     */
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    /**
     * 通过BeanName获取到实例化对象
     * @param beanName
     * @return
     */
    public Object getBean(String beanName){
        return getApplicationContext().getBean(beanName);
    }

    /**
     * 通过Class 对象获取到实例化对象
     * @param clazz
     * @return
     */
    public Object getBean(Class clazz){
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 通过BeanName和Class对象获取到实例化对象
     * @param beanName
     * @param clazz
     * @return
     */
    public static Object getBean(String beanName,Class clazz){
        return getApplicationContext().getBean(beanName,clazz);
    }

}
