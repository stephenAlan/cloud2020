package com.stephen.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ssc on 2020-04-19 22:01 .
 * Description:
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    // @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
