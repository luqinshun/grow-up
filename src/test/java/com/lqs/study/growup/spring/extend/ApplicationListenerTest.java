package com.lqs.study.growup.spring.extend;

import com.lqs.study.growup.spring.expand.application.NotifyEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

/**
 * @program: grow-up
 * @description: ApplicationListener 监听器
 * @author:luqinshun
 * @create: 2019-11-28 17:23
 **/

@SpringBootTest
public class ApplicationListenerTest {
    @Autowired
    private WebApplicationContext applicationContext;

    /**
     *  基于ApplicationListener 监听器实现的邮件发送方式
     */
    @Test
    public void sendEmail(){
        NotifyEvent notifyEvent = new NotifyEvent("String", "luqinshun-ds@gome.com.cn", "新的工作任务");
        applicationContext.publishEvent(notifyEvent);
    }
}
