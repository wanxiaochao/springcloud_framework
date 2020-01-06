package com.cloud.serviceprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.cloud.dubbo_interface.service.HelloDubboService;
import org.springframework.stereotype.Component;

@Service
@Component
public class HelloServiceImpl implements HelloDubboService {

    @Override
    public String helloDubboService(String name) {
        return "Hello dubbo service" + name;
    }
}
