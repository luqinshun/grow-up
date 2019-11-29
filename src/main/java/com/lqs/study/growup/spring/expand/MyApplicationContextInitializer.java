package com.lqs.study.growup.spring.expand;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @program: grow-up
 * @description: 通常用于需要对应用程序上下文进行编程初始化的web应用程序中
 *       常见于自定义的SpringBoot 启动包
 * @author:luqinshun
 * @create: 2019-11-28 17:40
 **/
public class MyApplicationContextInitializer implements ApplicationContextInitializer {
    /**
     *  使用方式   /resources/META-INF/spring.factories 中添加
     * @param configurableApplicationContext
     */
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("自定义初始化的方法——执行的程序");
    }
}
