package com.stephen.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by ssc on 2021-01-30 23:13 .
 * Description:
 */
@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${serviceUrl.nacos-server}")
    private String serverURL;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable Integer id) {
        return restTemplate.getForObject(serverURL + "/payment/nacos/" + id,String.class);
    }


}
