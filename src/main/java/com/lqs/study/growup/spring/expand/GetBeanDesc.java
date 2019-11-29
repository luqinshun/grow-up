package com.lqs.study.growup.spring.expand;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @program: grow-up
 * @description: 获取到Bean的详细描述数据
 *    Spring的 BeanFactoryPostProcessor 扩展接口
 * @author:luqinshun
 * @create: 2019-11-28 16:29
 **/
@Component
public class GetBeanDesc implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String beanName="myService";
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(beanName);
        System.out.println("beanDefinition: "+ beanDefinition.getBeanClassName());
        System.out.println("initMethodName: "+beanDefinition.getInitMethodName());
        System.out.println(beanDefinition.getScope());
    }
}
