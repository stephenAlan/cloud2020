package com.stephen.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ssc on 2021-01-30 23:15 .
 * Description:
 */
@Configuration
public class RestConfig {

    @Bean
    @LoadBalanced // ribbon和restTemplate做负载均衡必须加这个
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
