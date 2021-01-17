package com.stephen.springcloud.service.impl;

import com.stephen.springcloud.dao.OrderDao;
import com.stephen.springcloud.entity.Order;
import com.stephen.springcloud.service.AccountService;
import com.stephen.springcloud.service.OrderService;
import com.stephen.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ssc on 2021-01-17 11:04 .
 * Description:
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    @Override
    public void create(Order order) {
        log.info("新建订单");
        orderDao.create(order);

        log.info("订单微服务调用库存服务,扣减库存");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("订单微服务调用账户服务,扣减账户余额");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("修改订单状态为开始");
        orderDao.update(order.getUserId(),0);
        log.info("下订单结束");
    }
}
