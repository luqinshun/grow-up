package com.lqs.study.growup.spring.aop.jdk;

/**
 * @program: grow-up
 * @description:
 * @author:luqinshun
 * @create: 2020-04-10 15:08
 **/
public class ProxyTest {
    public static void main(String[] args) {
        Monkey monkey = new Monkey();
        AnimalProxy animalProxy = new AnimalProxy(monkey);
        Animal proxyObj = (Animal) animalProxy.createProxyObj();
        proxyObj.eat();
        proxyObj.run();
    }
}
