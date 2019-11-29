package com.lqs.study.growup.spring.expand.application;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @program: grow-up
 * @description: 监听事件 实体
 * @author:luqinshun
 * @create: 2019-11-28 17:18
 **/
@Getter
public class NotifyEvent extends ApplicationEvent {
    private String email;

    private String content;

    public NotifyEvent(Object source) {
        super(source);
    }

    public NotifyEvent(Object source,String email,String content){
        super(source);
        this.email=email;
        this.content=content;
    }


}
