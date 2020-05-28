package com.lqs.study.growup.designpattern.factory;

/**
 * @program: grow-up
 * @description: 静态工厂实现
 * 优点：将创建使用工作分开，不必关心类对象如何创建，实现了解耦；
 * 缺点：违背“开放 - 关闭原则”，一旦添加新产品就不得不修改工厂类的逻辑，这样就会造成工厂逻辑过于复杂。
 * @author:luqinshun
 * @create: 2020-05-28 12:37
 **/
public class StaticProductFactory {

    public static Product create(String productName){
        if("compute".equals(productName)){
            return new Compute();
        }else if("mouse".equals(productName)){
            return new Mouse();
        }
        return null;
    }
}
