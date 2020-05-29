package com.lqs.study.growup.designpattern.chain;

/**
 * @program: grow-up
 * @description:
 * @author:luqinshun
 * @create: 2020-05-29 19:29
 **/
abstract class AbstractStepRunner implements Step{
    abstract void before();

    abstract void after();

    public final void run(){
        before();
        execute();
        after();
    }
}
