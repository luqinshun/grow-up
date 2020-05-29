package com.lqs.study.growup.algorithm.fuse;

import java.util.concurrent.*;

/**
 * @program: grow-up
 * @description: 线程池的方式实现熔断器
 * @author:luqinshun
 * @create: 2020-05-29 12:15
 **/
public class ThreadPoolBreaker {
    private ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void testBreak(){
        Future<String> execute = threadPool.submit(() -> {
            System.out.println("熔断器执行内容");
            return "熔断器返回值";
        });
        try {
            String str = execute.get(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
