package com.mrlqq.springcloud.service;

import com.mrlqq.springcloud.entities.CommonResult;
import com.mrlqq.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Classname PaymentFeignService
 * @Description TODO
 * @Date 2022/2/2 22:16
 * @Created by LQQ
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @PostMapping("/payment/create")
    CommonResult create(@RequestBody Payment payment);

    @GetMapping("/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/discovery")
    Object discovery();

    @GetMapping( "/payment/feign/timeout")
    String paymentFeignTimeout();
}
