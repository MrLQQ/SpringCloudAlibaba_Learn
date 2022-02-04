package com.mrlqq.springcloud.controller;

import com.mrlqq.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname OrderHystrixController
 * @Description TODO
 * @Date 2022/2/3 23:57
 * @Created by LQQ
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_OK(id);
        log.info("*******result:"+result);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    //@HystrixCommand(fallbackMethod = "paymentTimeoutFallbackMethod",commandProperties = {
    //        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    //})
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        // 故意添加一个计算异常，测试出错后，时候会调用fallback
        int age = 10/0;
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        log.info("*******result:"+result);
        return result;
    }
    public String paymentTimeoutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80，对方系统繁忙……";
    }

    // 下面是全局fallback方法
    public String  payment_Global_FallbackMethod(){
        return "Global异常处理消息，请稍后再试……";
    }
}
