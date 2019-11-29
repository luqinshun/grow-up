package com.lqs.study.growup.thread;

import org.junit.jupiter.api.Test;

/**
 * @program: grow-up
 * @description: 等待线程池完毕测试类
 * @author:luqinshun
 * @create: 2019-11-11 19:48
 **/
public class WaitThreadPoolFinishTests {

    @Test
    public void waitThreadTest(){
        WaitThreadPoolFinish waitThreadPool = new WaitThreadPoolFinish();
        waitThreadPool.theadWait();
    }

    @Test
    public void countdownTest() throws InterruptedException {
        WaitThreadPoolFinish threadPoolFinish = new WaitThreadPoolFinish();
        threadPoolFinish.countDownLatch();
    }
}
