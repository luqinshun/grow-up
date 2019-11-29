package com.lqs.study.growup.spring.aop;

import com.lqs.study.growup.spring.service.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: grow-up
 * @description: spring aop 测试类
 * @author:luqinshun
 * @create: 2019-11-28 11:25
 **/
@SpringBootTest
public class SpringAopTest {
    @Autowired
    private MyService myService;

    @Test
    public void testAop(){
        myService.testService();
    }

}
