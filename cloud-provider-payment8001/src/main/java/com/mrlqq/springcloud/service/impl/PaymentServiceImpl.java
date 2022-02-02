package com.mrlqq.springcloud.service.impl;

import com.mrlqq.springcloud.dao.PaymentDao;
import com.mrlqq.springcloud.entities.Payment;
import com.mrlqq.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname PaymentServiceImpl
 * @Description TODO
 * @Date 2022/1/25 19:06
 * @Created by LQQ
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(@Param("id") Long id) {
        return paymentDao.getPaymentById(id);
    }
}
