package com.stephen.springcloud.service;


import com.stephen.springcloud.entity.Order;
import org.springframework.stereotype.Component;

@Component
public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}
