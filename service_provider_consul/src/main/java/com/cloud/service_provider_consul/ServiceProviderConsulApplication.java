package com.cloud.service_provider_consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceProviderConsulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderConsulApplication.class, args);
    }

}
