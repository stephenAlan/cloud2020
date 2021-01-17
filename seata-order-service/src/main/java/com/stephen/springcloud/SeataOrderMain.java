package com.stephen.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by ssc on 2021-01-15 23:34 .
 * Description:
 */
@MapperScan(basePackages = {"com.stephen.springcloud.dao"})
@EnableDiscoveryClient
@EnableFeignClients
// 取消数据源自动创建
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SeataOrderMain {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMain.class,args);
    }
}
