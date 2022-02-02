package com.mrlqq.springcloud.controller;

import com.mrlqq.springcloud.entities.CommonResult;
import com.mrlqq.springcloud.entities.Payment;
import com.mrlqq.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Classname OrderFeignController
 * @Description TODO
 * @Date 2022/2/2 22:25
 * @Created by LQQ
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @PostMapping("/consumer/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        return paymentFeignService.create(payment);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/discovery")
    public Object discovery(){
        return paymentFeignService.discovery();
    }
}
