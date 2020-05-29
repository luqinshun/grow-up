package com.lqs.study.growup.algorithm.fuse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.concurrent.*;

/**
 * @program: grow-up
 * @description:
 * @author:luqinshun
 * @create: 2020-05-29 12:27
 **/
@Configuration
@Aspect
public class BreakerConfig {
    private static int CPU_COUNT=Runtime.getRuntime().availableProcessors();

    private ThreadPoolExecutor threadPool=new ThreadPoolExecutor(CPU_COUNT*3,CPU_COUNT*3,0,TimeUnit.SECONDS,new LinkedBlockingQueue<>());

    @Pointcut(value = "@annotation(com.lqs.study.growup.algorithm.fuse.Breaker)")
    public void pointCut(){}

    @Around("pointCut()")
    public Object breaker(ProceedingJoinPoint joinPoint) {
        //获取到方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Breaker breakerAnno = method.getAnnotation(Breaker.class);
        int timeout = breakerAnno.timeout();
        TimeUnit timeUnit = breakerAnno.timeUnit();
        Future<Object> submit = threadPool.submit(() -> {
            Object proceed = null;
            try {
                proceed = joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                return null;
            }
            return proceed;
        });
        try {
            Object result = submit.get(timeout, timeUnit);
            return result;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            //e.printStackTrace();
            return "返回熔断信息";
        }
        return null;
    }

}
