package com.stephen.springcloud.constroller;

import com.stephen.springcloud.service.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by ssc on 2020-12-12 19:33 .
 * Description:
 */
@RestController
@Slf4j
@RequestMapping("consumer")
public class ConsumerPaymentController {

    @Resource
    private FeignService feignService;

    @GetMapping("paymentOk")
    public String paymentOk() {
        return feignService.paymentOk();
    }

    @GetMapping("paymentTimeout")
    public String paymentTimeout() {
        return feignService.paymentTimeout();
    }

}
