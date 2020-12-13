package com.stephen.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by ssc on 2020-12-12 19:34 .
 * Description:
 */
@FeignClient(name = "cloud-provider-hystrix-payment"/*,fallback = PaymentFallbackService.class*/)
public interface FeignService {


    @GetMapping("provider/paymentOk")
    String paymentOk();

    @GetMapping("provider/paymentTimeout")
    String paymentTimeout();

}
