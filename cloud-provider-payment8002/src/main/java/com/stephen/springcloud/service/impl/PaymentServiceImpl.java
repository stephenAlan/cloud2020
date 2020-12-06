package com.stephen.springcloud.service.impl;

import com.stephen.springcloud.dao.PaymentDao;
import com.stephen.springcloud.entities.Payment;
import com.stephen.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ssc on 2020-04-19 18:53 .
 * Description:
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
