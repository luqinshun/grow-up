package com.lqs.study.growup.spring.expand;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @program: grow-up
 * @description: Spring容器启动后最后一步时候得回调
 * @author:luqinshun
 * @create: 2019-11-28 19:10
 **/
@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Spring容器执行完毕最后一步。。。。。");
    }
}
