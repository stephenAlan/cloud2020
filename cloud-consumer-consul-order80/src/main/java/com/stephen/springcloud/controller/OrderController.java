package com.stephen.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by ssc on 2020-12-10 22:08 .
 * Description:
 */
@RestController
@Slf4j
public class OrderController {

    private static final String URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("consumer/consul")
    public String consulOrder() {
        String result = restTemplate.getForObject(URL + "/payment/consul", String.class);
        return result;
    }

}
