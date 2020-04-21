package com.lqs.study.growup.tool;

import org.junit.jupiter.api.Test;

/**
 * @program: grow-up
 * @description: IpUtils ip获取工具
 * @author:luqinshun
 * @create: 2019-11-11 20:17
 **/
public class IpUtilsTest {

    @Test
    public void getIpTest() throws Exception {
        String ip = IpUtils.getIp();
        System.out.println("ip地址："+ ip);
    }


}
