package com.lqs.study.growup.designpattern.chain;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @program: grow-up
 * @description:
 * @author:luqinshun
 * @create: 2020-05-29 19:18
 **/
public class StepChain implements Step {
    /**
     * 基于Jdk 链表实现
     */
    List<AbstractStepRunner> stepChains=new LinkedList<>();
    private int index;
    public void init(){
        index=0;
    }

    public void add(AbstractStepRunner step){
        stepChains.add(step);
    }

    /**
     * 方式一： 使用递归的方式实现责任链
     */
    @Override
    public void execute() {
        //执行完毕后退出
        if(index==stepChains.size()){
            return;
        }

        Step step = stepChains.get(index);
        step.execute();
        index++;
        execute();
    }

    /**
     * 方式二： 使用迭代的方式实现， SpringMVC使用此方式实现拦截器
     */
    public void execute1(){
        for(int i=0;i<stepChains.size();i++){
            AbstractStepRunner stepRunner = stepChains.get(i);
            stepRunner.execute();
        }
    }


}
