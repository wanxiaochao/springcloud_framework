package com.cloud.servicehystrixfeign.controller;

import com.cloud.servicehystrixfeign.feign.TestFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestFeignClient userRemoteClient;

    /**
     * 利用feign调用
     */
    @GetMapping("/callHello")
    public String callHello() {
        String result = userRemoteClient.hello();
        System.out.println("调用结果：" + result);
        return result;
    }


}
