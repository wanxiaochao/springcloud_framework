package com.cloud.service_consumer_consul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/article/callHello2")
    public String callHello2(HttpServletRequest request) {
        String name1 = request.getHeader("NAME1");
        String name2 = request.getHeader("NAME2");
        String forObject = restTemplate.getForObject("http://service-provider-consul/user/hello", String.class);
        return name1 + ":" + name2 + ":" + forObject;
    }
}
