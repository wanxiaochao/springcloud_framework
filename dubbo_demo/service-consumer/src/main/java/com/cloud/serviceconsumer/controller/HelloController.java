package com.cloud.serviceconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cloud.dubbo_interface.service.HelloDubboService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Reference
    private HelloDubboService helloService;

    @RequestMapping("/hello")
    public String hello() {
        String zhangsan = helloService.helloDubboService("zhangsan");
        return zhangsan;
    }
}
