package com.stephen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ssc on 2021-01-07 22:24 .
 * Description:
 */
@SpringBootApplication
@EnableConfigServer
@RestController
public class ConfigCenterMain3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class,args);
    }

    @RequestMapping()
    public String hello() {
        return "hello";
    }

}
