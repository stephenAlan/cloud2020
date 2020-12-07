package com.stephen.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by ssc on 2020-12-06 22:22 .
 * Description:
 */
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("zk")
    public String paymentZk() {
        return "springcloud with zk: " + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
