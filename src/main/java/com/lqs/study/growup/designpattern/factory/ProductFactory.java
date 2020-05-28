package com.lqs.study.growup.designpattern.factory;

/**
 * @program: grow-up
 * @description: 工厂模式
 * 优点：
 *
 * 符合开-闭原则：新增一种产品时，只需要增加相应的具体产品类和相应的工厂子类即可
 * 符合单一职责原则：每个具体工厂类只负责创建对应的产品
 * 缺点：
 *
 * 增加了系统的复杂度：类的个数将成对增加
 * 增加了系统的抽象性和理解难度
 * 一个具体工厂只能创建一种具体产品
 * @author:luqinshun
 * @create: 2020-05-28 12:41
 **/
public abstract class ProductFactory {
    protected abstract Product create();
}

/**
 * 子工厂的实现
 */
class ComputeFactory extends ProductFactory{

    @Override
    protected Product create() {
        return new Compute();
    }
}

/**
 * 鼠标工厂实现
 */
class MouseFactory extends ProductFactory{

    @Override
    protected Product create() {
        return new Mouse();
    }
}
