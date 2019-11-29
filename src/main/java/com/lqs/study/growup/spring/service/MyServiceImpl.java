package com.lqs.study.growup.spring.service;

import com.lqs.study.growup.spring.aop.TestAnnotation;
import org.springframework.stereotype.Service;

/**
 * @program: grow-up
 * @description: 服务类测试
 * @author:luqinshun
 * @create: 2019-11-28 11:22
 **/
@Service("myService")
public class MyServiceImpl implements MyService {

    @Override
    @TestAnnotation("myService")
    public String testService() {
        System.out.println("testService");
        return "MyService-test";
    }
}
