package com.cloud.servicehystrixfeign.fallback;

import com.cloud.servicehystrixfeign.feign.TestFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TestRemoteClientFallbackFactory implements FallbackFactory<TestFeignClient> {

    private Logger logger = LoggerFactory.getLogger(TestRemoteClientFallbackFactory.class);

    @Override
    public TestFeignClient create(final Throwable throwable) {
        logger.info("调用service-provider服务失败!");
        return new TestFeignClient() {
            @Override
            public String hello() {
                return "服务异常!";
            }
        };
    }
}
