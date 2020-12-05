package com.stephen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by ssc on 2020-04-19 18:06 .
 * Description:
 */
@SpringBootApplication
// @EnableEurekaClient  // 表明是Eureka client
// @EnableDiscoveryClient
public class PaymentMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class,args);
    }

}
