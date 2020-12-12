package com.stephen.springcloud;

import com.stephen.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Created by ssc on 2020-04-19 21:54 .
 * Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "CLOUD_PAYMENT_SERVICE",configuration = MySelfRule.class)
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
