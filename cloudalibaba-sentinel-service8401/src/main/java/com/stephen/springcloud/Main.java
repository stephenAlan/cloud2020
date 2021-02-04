package com.stephen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by ssc on 2021-02-04 21:36 .
 * Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
