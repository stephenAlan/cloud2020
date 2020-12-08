package com.stephen.springcloud.controller;

import com.stephen.springcloud.entities.CommonResult;
import com.stephen.springcloud.entities.Payment;
import com.stephen.springcloud.service.PaymentService;
import com.stephen.springcloud.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private TransactionTemplate transactionTemplate;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        // int result = paymentService.create(payment);
        // log.info("插入payment结果： " + result);
        // log.info("from server: " + serverPort);
        // int i = 1 / 0;
        Boolean result = testTransaction(payment);
        if (result) {
            return ResultUtils.success("server.port:" + serverPort,result);
        } else {
            return ResultUtils.fail();
        }
    }

    public Boolean testTransaction(Payment payment) {
        Integer result = transactionTemplate.execute(new TransactionCallback<Integer>() {
            @Override
            public Integer doInTransaction(TransactionStatus status) {
                try {
                    int result = paymentService.create(payment);
                    log.info("插入payment结果： " + result);
                    log.info("from server: " + serverPort);
                    int i = 1 / 0;
                    return 1;
                } catch (Exception e) {
                    status.setRollbackOnly();
                    log.info(e.getMessage(), e);
                }
                return 0;
            }
        });
        return result != null && result > 0 ? true : false;
    }


    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询成功,id: " + id);
        log.info("from server: " + serverPort);
        log.info("success-----------------");
        if (payment != null) {
            return ResultUtils.success("server.port:" + serverPort,payment);
        } else {
            return ResultUtils.fail("id: " + id);
        }
    }

    @GetMapping("/discovery")
    public Object discovery() {
        // 获取注册在Eureka上的所有服务
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);
        // 获取某个服务下的所有实例
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        instances.forEach(e -> {
            log.info("serviceId:{}",e.getServiceId());
            log.info("instanceId:{}",e.getInstanceId());
            log.info("host:{}",e.getHost());
            log.info("port:{}",e.getPort());
            log.info("uri:{}",e.getUri());

        });
        return discoveryClient;
    }

}
