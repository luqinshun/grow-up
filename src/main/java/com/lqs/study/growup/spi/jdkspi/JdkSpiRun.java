package com.lqs.study.growup.spi.jdkspi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @program: grow-up
 * @description:
 * @author:luqinshun
 * @create: 2020-05-08 10:19
 * 1、JDK SPI 概念：
 *      SPI （Service Provider Interface） 是JDK内置的服务提供机制
 * 2、使用场景： 日志模块、JDBC Driver模块、xml模块
 * 3、使用方式：
 * 当服务的提供者，提供了服务接口的一种实现之后，在jar包中META-INF/services目录里同时创建一个以服务接口命名的文件。
 * 该文件里就是实现该服务接口的具体实现类（全称）。
 * 而当外部程序装配这个模块的时候，就能通过该jar包META-INF/services/里的配置文件找到具体的实现类名，并装载实例化，完成模块的注入
 *
 * 4、原生缺点：
 *   a、Jdk默认会将目标文件下的所有定义的子类全部加装，包括可能没有使用的类
 *   b、定义多个子类时，无法动态的根据配置来使用不同的配置
 **/
public class JdkSpiRun {

    public static void main(String[] args) {
        ServiceLoader<IHello> serviceLoader= ServiceLoader.load(IHello.class);
        Iterator<IHello> iterator = serviceLoader.iterator();
        while (iterator.hasNext()){
            IHello ihello = iterator.next();
            ihello.say();
        }
    }
}
