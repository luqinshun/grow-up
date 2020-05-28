package com.lqs.study.growup.designpattern.factory.abstrac;

/**
 * @program: grow-up
 * @description:
 * @author:luqinshun
 * @create: 2020-05-28 20:10
 **/
public class SouthFruitFactory implements FruitFactory{
    @Override
    public Fruit getApple() {
        return new SouthApple();
    }

    @Override
    public Fruit getOrange() {
        return new SouthOrange();
    }
}
