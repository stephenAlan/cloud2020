package com.stephen.springcloud.service;

import com.stephen.springcloud.entities.Payment;

/**
 * Created by ssc on 2020-04-19 18:52 .
 * Description:
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);

}
