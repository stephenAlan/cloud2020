package com.stephen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by ssc on 2020-12-07 23:53 .
 * Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerPaymentMain {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerPaymentMain.class,args);
    }

}
