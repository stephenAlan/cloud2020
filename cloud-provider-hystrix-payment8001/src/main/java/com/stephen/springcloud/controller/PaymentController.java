package com.stephen.springcloud.controller;

import com.stephen.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by ssc on 2020-12-12 19:02 .
 * Description:
 */
@RestController
@Slf4j
@RequestMapping("provider")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("paymentOk")
    public String paymentOk() {
        return paymentService.paymentOk();
    }

    @GetMapping("paymentTimeout")
    public String paymentTimeout() throws InterruptedException {
        return paymentService.paymentTimeout();
    }

}
