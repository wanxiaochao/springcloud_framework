package com.cloud.servicehystrixfeign.fallback;

import com.cloud.servicehystrixfeign.feign.TestFeignClient;
import org.springframework.stereotype.Component;

@Component
public class TestRemoteClientFallback implements TestFeignClient {

    @Override
    public String hello() {
        return "服务异常!";
    }
}
