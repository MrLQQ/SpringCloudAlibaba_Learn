package com.mrlqq.springcloud.controller;

import com.mrlqq.springcloud.domain.CommonResult;
import com.mrlqq.springcloud.domain.Order;
import com.mrlqq.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname OrderController
 * @Description TODO
 * @Date 2022/2/11 22:35
 * @Created by LQQ
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult<>(200,"订单创建成功");
    }
}
