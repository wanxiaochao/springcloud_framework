package com.cloud.service_consumer_feign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "service-provider")
public interface TestFeignClient {

    @GetMapping("/user/hello")
    String hello();

}
