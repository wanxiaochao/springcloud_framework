package com.cloud.servicehystrixfeign.feign;

import com.cloud.servicehystrixfeign.config.FeignConfiguration;
import com.cloud.servicehystrixfeign.fallback.TestRemoteClientFallback;
import com.cloud.servicehystrixfeign.fallback.TestRemoteClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(value = "service-provider", fallback = TestRemoteClientFallback.class)//fallback方式熔断
@FeignClient(value = "service-provider", configuration = FeignConfiguration.class, fallbackFactory = TestRemoteClientFallbackFactory.class)
public interface TestFeignClient {

    @GetMapping("/user/hello")
    String hello();

}
