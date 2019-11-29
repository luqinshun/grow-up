package com.lqs.study.growup.spring.expand.application;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @program: grow-up
 * @description: Spring的 ApplicationListener 扩展接口
 * @author:luqinshun
 * @create: 2019-11-28 17:20
 **/
@Component
public class MyApplicationListener implements ApplicationListener<NotifyEvent> {
    @Override
    public void onApplicationEvent(NotifyEvent notifyEvent) {
        String email = notifyEvent.getEmail();
        String content = notifyEvent.getContent();
        System.out.println("email: "+ email+"   content: "+ content);
    }
}
