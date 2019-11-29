package com.lqs.study.growup.spring.expand;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: grow-up
 * @description: Bean的属性设置后的操作，以及销毁的操作
 * @author:luqinshun
 * @create: 2019-11-28 19:36
 **/
@Component
public class MyInitalingBean implements InitializingBean, DisposableBean {
    private String userName;

    @Override
    public void destroy() throws Exception {
        System.out.println("属性销毁后的操作");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("属性设置后的操作");
    }

    @Value("${my.userName}")
    public void setUserName(String userName){
        System.err.println("属性设置的值： "+ userName);
        this.userName=userName;
    }
}
