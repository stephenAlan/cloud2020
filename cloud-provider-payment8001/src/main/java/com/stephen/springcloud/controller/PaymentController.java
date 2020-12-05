package com.stephen.springcloud.controller;

import com.stephen.springcloud.entities.CommonResult;
import com.stephen.springcloud.entities.Payment;
import com.stephen.springcloud.service.PaymentService;
import com.stephen.springcloud.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ssc on 2020-04-19 18:55 .
 * Description:
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入payment结果： " + result);
        log.info("from server: " + serverPort);
        if (result > 0) {
            return ResultUtils.success("server.port:" + serverPort,result);
        } else {
            return ResultUtils.fail();
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询成功,id: " + id);
        log.info("from server: " + serverPort);
        if (payment != null) {
            return ResultUtils.success("server.port:" + serverPort,payment);
        } else {
            return ResultUtils.fail("id: " + id);
        }
    }

    // @GetMapping("/discovery")
    // public Object discovery() {
    //     // 获取注册在Eureka上的所有服务
    //     List<String> services = discoveryClient.getServices();
    //     services.forEach(System.out::println);
    //     // 获取某个服务下的所有实例
    //     List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
    //     instances.forEach(e -> {
    //         log.info("serviceId:{}",e.getServiceId());
    //         log.info("instanceId:{}",e.getInstanceId());
    //         log.info("host:{}",e.getHost());
    //         log.info("post:{}",e.getPort());
    //         log.info("uri:{}",e.getUri());
    //
    //     });
    //     return discoveryClient;
    // }

}
