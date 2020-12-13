package com.stephen.springcloud.constroller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
@DefaultProperties(defaultFallback = "global_fallback")
public class ConsumerPaymentController {

    @Resource
    private FeignService feignService;

    @GetMapping("paymentOk")
    public String paymentOk() {
        return feignService.paymentOk();
    }

    @HystrixCommand
    // @HystrixCommand(fallbackMethod = "paymentTimeout_fallback",commandProperties = { // 3秒超时
    //         @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "6000")
    // })
    @GetMapping("paymentTimeout")
    public String paymentTimeout() throws InterruptedException {
        // int i = 1 / 0;
        return  feignService.paymentTimeout() ;
    }

    public String paymentTimeout_fallback() throws InterruptedException {
        return "consumer 80 支付系统繁忙，请稍后再试";
    }

    public String global_fallback() throws InterruptedException {
        return "global_fallback method handler";
    }


}
