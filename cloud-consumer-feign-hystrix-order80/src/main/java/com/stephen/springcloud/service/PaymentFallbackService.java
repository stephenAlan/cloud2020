package com.stephen.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * Created by ssc on 2020-12-13 11:09 .
 * Description:
 */
@Component
public class PaymentFallbackService implements FeignService {
    @Override
    public String paymentOk() {
        return "PaymentFallbackService    paymentOk";
    }

    @Override
    public String paymentTimeout() {
        return "PaymentFallbackService   paymentTimeout";
    }
}
