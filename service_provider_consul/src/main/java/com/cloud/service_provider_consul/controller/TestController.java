package com.cloud.service_provider_consul.controller;

import com.cloud.service_provider_consul.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/user/hello")
    public String hello() {
        User user = new User();
        user.setAge("1500");
        user.setName("张三");
        user.setSex("女");
        return user.toString();
    }


}
