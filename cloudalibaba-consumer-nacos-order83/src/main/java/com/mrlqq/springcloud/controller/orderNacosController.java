package com.mrlqq.springcloud.controller;

import com.mrlqq.springcloud.server.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname orderNacosController
 * @Description TODO
 * @Date 2022/2/7 23:30
 * @Created by LQQ
 */
@RestController
@Slf4j
public class orderNacosController {

    @Resource
    PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    String getPayment(@PathVariable("id") Integer id){
        return paymentFeignService.getPayment(id);
    }

}
