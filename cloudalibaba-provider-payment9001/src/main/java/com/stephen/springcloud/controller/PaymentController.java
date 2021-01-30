package com.stephen.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ssc on 2021-01-30 22:49 .
 * Description:
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/nacos/{abc}")
    public String getPayment(@PathVariable("abc") Integer id) {
        return "Nacos discovery, serverPort: " + serverPort + "\t" + id ;
    }

}
