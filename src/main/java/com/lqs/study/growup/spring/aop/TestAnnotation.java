package com.lqs.study.growup.spring.aop;


import java.lang.annotation.*;

/**
 * @author luqinshun
 */ // 注解使用的范围
@Target(ElementType.METHOD)
// 注解使用的时期
@Retention(RetentionPolicy.RUNTIME)
// 能够将注解 放在doc中
@Documented
public @interface TestAnnotation {
    String value();
}
