package com.lqs.study.growup.algorithm.fuse;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @author luqinshun
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Breaker {

    int timeout() default 2000;

    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;



}
