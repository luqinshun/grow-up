package com.lqs.study.growup.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: grow-up
 * @description: Aop 注解解析器
 * @author:luqinshun
 * @create: 2019-11-26 11:06
 **/
@Component
@Aspect
@Slf4j
public class AopHandler {

    @Pointcut("@annotation(com.lqs.study.growup.spring.aop.TestAnnotation)")
    public void annotationPointcut(){};

    /**
     * 方法执行之前
     * @param joinPoint
     */
    //@Before(value = "annotationPointcut()")
    public void beforeAop(JoinPoint joinPoint){
        // Http请求之前的aop拦截方式
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        // 获取请求路径
        String requestURI = request.getRequestURI();
        // 获取请求方法
        String method = request.getMethod();
        // 获取请求IP
        String remoteAddr = request.getRemoteAddr();
        Object[] args = joinPoint.getArgs();


    }

    /**
     *  环绕执行
     *   作用： 统计请求执行的时间
     *         请求参数和接口返回数据的记录
     *
     *   Around 可以改变返回值
     * @param joinPoint
     */
    @Around(value = "annotationPointcut()")
    public Object aroundAop(ProceedingJoinPoint joinPoint) throws Throwable {
        String kind = joinPoint.getKind();
        System.out.println("kind: "+ kind);
        SourceLocation sourceLocation = joinPoint.getSourceLocation();

        //方法的执行,结果
        System.out.println("aroundAop: 方法执行前");
        Object result = joinPoint.proceed();
        System.out.println("aroundAop: 方法执行后");
        return result;
    }

    /**
     * 方法执行后
     * @param joinPoint
     */
    @AfterReturning(returning = "ret",value = "annotationPointcut()")
    public void afterAop(JoinPoint joinPoint,Object ret){
        // 返回值的处理
        String name = joinPoint.getSignature().getName();
        int modifiers = joinPoint.getSignature().getModifiers();
        System.out.println("modifiers: "+ modifiers);
        System.out.println("name: "+ name);
        System.out.println("返回值为： "+ ret);
    }

    /**
     * 方法执行后，抛出异常的处理
     *  throwing 限定位只有抛出异常的时候执行
     */
    @AfterThrowing(value = "annotationPointcut()",throwing = "exception")
    public void afterThrowing(JoinPoint point,Exception exception){
        Signature signature = point.getSignature();

        if(exception instanceof NullPointerException){
            // 如果是空指针，进行处理
        }

    }

}
