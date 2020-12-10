package com.stephen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by ssc on 2020-12-10 22:07 .
 * Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsulMain {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsulMain.class,args);
    }
}
