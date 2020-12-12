package com.stephen.springcloud.service;

import com.stephen.springcloud.entities.CommonResult;
import com.stephen.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by ssc on 2020-12-12 16:41 .
 * Description:
 */
@FeignClient(name = "cloud-payment-service")
public interface PaymentFeignService {

    // 此处必须是全路径,如果payment服务有上下文也要加上上下文路径
    @GetMapping("pay/payment/get/{id}")
    CommonResult<Payment> get(@PathVariable("id") Long id);

}
