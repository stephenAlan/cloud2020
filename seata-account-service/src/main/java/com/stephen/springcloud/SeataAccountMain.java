package com.stephen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by ssc on 2021-01-18 9:00 .
 * Description:
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class SeataAccountMain {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccountMain.class,args);
    }
}
