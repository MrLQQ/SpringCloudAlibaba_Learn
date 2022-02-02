package com.mrlqq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname OrderZKMaini80
 * @Description TODO
 * @Date 2022/1/30 13:18
 * @Created by LQQ
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKMaini80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZKMaini80.class,args);
    }
}
