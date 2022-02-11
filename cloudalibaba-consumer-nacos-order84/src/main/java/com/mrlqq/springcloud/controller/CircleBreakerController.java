package com.mrlqq.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mrlqq.springcloud.entities.CommonResult;
import com.mrlqq.springcloud.entities.Payment;
import com.mrlqq.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname CircleBreakerController
 * @Description TODO
 * @Date 2022/2/11 16:40
 * @Created by LQQ
 */
@RestController
@Slf4j
public class CircleBreakerController {

    @Resource
    PaymentService paymentFeignService;

    @GetMapping(value = "/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback", fallback = "handlerFallback")
    //@SentinelResource(value = "fallback", blockHandler = "blockHandler")
    @SentinelResource(value = "fallback",fallback = "handlerFallback",
            blockHandler = "blockHandler",
            exceptionsToIgnore ={IllegalArgumentException.class} )
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){

        CommonResult<Payment> result = paymentFeignService.paymentSQL(id);
        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return result;
    }

    // fallback
    public CommonResult handlerFallback(@PathVariable  Long id,Throwable e) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(444,"兜底异常handlerFallback,exception内容  "+e.getMessage(),payment);
    }

    //blockHandler
    public CommonResult blockHandler(@PathVariable  Long id, BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(445,"blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage(),payment);
    }

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/openfeign/{id}")
    CommonResult<Payment> openfeignPaymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }

}
