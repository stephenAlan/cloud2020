package com.stephen.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by ssc on 2020-12-10 21:55 .
 * Description:
 */
@RestController
@Slf4j
public class PayController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("payment/consul")
    public String paymentConsul() {
        return "springcloud with consul: " + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
