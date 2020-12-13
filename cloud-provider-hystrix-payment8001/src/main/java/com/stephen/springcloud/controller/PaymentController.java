package com.stephen.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.stephen.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("payment/circle/{id}")
    @HystrixCommand(fallbackMethod = "global_fallback"
            ,commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启熔断器
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "10000"),//请求的时间窗口期
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),// sleep窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") // 失败比例60%
            /* 1. 每10秒的窗口期,当请求次数超过10次,且失败比例超过60%时,打开熔断器
             *  2. 当熔断器打开5秒(即sleep窗口期)后,尝试放一部分请求,若正常,则恢复链路,若仍异常,则继续开启熔断
             * */
    }
    )
    public String paymentCircuitBreadker(@PathVariable("id") Long id) {
        if (id < 0) {
            throw  new RuntimeException();
        }
        String uuid = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + uuid;
    }

    public String global_fallback(@PathVariable("id") Long id) {
        return "global fallback ";
    }

}
