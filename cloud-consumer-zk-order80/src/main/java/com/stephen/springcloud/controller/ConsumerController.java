package com.stephen.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by ssc on 2020-12-07 23:49 .
 * Description:
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    private static final String URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("payment/zk")
    public String paymentZk() {

        return restTemplate.getForObject(URL + "/payment/zk",String.class);
    }

}
