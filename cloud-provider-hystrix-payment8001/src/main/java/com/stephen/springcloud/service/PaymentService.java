package com.stephen.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by ssc on 2020-12-12 18:59 .
 * Description:
 */
@Service
public class PaymentService {

    @Value("${server.port}")
    private String serverPort;

    public String paymentOk(){
        return serverPort + Thread.currentThread().getName() + "\t" + "paymentOk";
    }

    @HystrixCommand(fallbackMethod = "paymentTimeout_fallback",commandProperties = { // 3秒超时
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentTimeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return serverPort + "\t"+ Thread.currentThread().getName() + "\t" + "paymentTimeout";
    }

    public String paymentTimeout_fallback() throws InterruptedException {
        return serverPort+"\t" + Thread.currentThread().getName() + "\t" + "paymentTimeout_fallback";
    }

}
