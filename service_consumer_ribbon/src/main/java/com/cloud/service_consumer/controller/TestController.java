package com.cloud.service_consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    /*** 不利用eureka调用*/
    /*    @GetMapping("/article /callHello")
    public String callHello() {
        return restTemplate.getForObject("http://localhost:8081/user/hello", String.class);
    }*/

    /*** 用eureka调用 这里其实ribbon已经做了负载均衡？ */
    @GetMapping("/article/callHello2")
    public String callHello2() {
        return restTemplate.getForObject("http://service-provider/user/hello", String.class);
    }
}
