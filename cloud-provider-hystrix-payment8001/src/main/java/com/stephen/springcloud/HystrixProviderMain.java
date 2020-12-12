package com.stephen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by ssc on 2020-12-12 18:59 .
 * Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker // Hystrix生效注解
public class HystrixProviderMain {

    public static void main(String[] args) {
        SpringApplication.run(HystrixProviderMain.class,args);
    }
}
