package com.cloud.servicehystrixfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.cloud.servicehystrixfeign")
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard//http://localhost:8766/hystrix 单机监控
@EnableTurbine//http://localhost:8766/turbine.stream 集群监控
public class ServiceHystrixFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHystrixFeignApplication.class, args);
    }

}
