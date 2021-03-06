package com.stephen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by ssc on 2021-01-30 23:11 .
 * Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosOrderMain {

    public static void main(String[] args) {
        SpringApplication.run(NacosOrderMain.class,args);
    }
}
