package com.stephen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by ssc on 2021-01-30 22:44 .
 * Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Nacos9001Main {

    public static void main(String[] args) {
        SpringApplication.run(Nacos9001Main.class,args);
    }

}
