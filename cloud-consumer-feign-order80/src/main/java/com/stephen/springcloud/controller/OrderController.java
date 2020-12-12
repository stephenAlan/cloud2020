package com.stephen.springcloud.controller;

import com.stephen.springcloud.entities.CommonResult;
import com.stephen.springcloud.entities.Payment;
import com.stephen.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by ssc on 2020-12-12 16:44 .
 * Description:
 */
@RestController
@Slf4j
@RequestMapping("consumer")
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        return paymentFeignService.get(id);
    }


}
