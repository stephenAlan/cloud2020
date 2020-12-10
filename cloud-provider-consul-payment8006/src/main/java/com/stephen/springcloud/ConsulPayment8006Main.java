package com.stephen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by ssc on 2020-12-10 21:53 .
 * Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulPayment8006Main {

    public static void main(String[] args) {
        SpringApplication.run(ConsulPayment8006Main.class,args);
    }
}
