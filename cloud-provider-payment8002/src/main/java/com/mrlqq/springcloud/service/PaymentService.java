package com.mrlqq.springcloud.service;

import com.mrlqq.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname PaymentService
 * @Description TODO
 * @Date 2022/1/25 19:05
 * @Created by LQQ
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
