package com.stephen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by ssc on 2021-01-06 22:07 .
 * Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWayMain {

    public static void main(String[] args) {
        SpringApplication.run(GateWayMain.class,args);
    }

}
