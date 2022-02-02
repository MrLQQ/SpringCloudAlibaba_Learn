package com.mrlqq.springcloud.dao;

import com.mrlqq.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname PaymentDao
 * @Description TODO
 * @Date 2022/1/25 18:40
 * @Created by LQQ
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
