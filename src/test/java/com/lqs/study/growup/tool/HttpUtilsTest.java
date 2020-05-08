package com.lqs.study.growup.tool;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @program: grow-up
 * @description:
 * @author:luqinshun
 * @create: 2019-12-21 18:38
 **/
public class HttpUtilsTest {

    public void httpTest(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:71.0) Gecko/20100101 Firefox/71.0");
        HttpEntity<String> requestEntity = new HttpEntity<String>(null, httpHeaders);
        ResponseEntity<String> exchange = restTemplate.exchange("https://www.toutiao.com/i6772516608570032652/", HttpMethod.GET, requestEntity, String.class);
        String body = exchange.getBody();
        System.out.println(body);
    }

}
