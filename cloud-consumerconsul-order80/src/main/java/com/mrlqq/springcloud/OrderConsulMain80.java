package com.mrlqq.springcloud;

import cn.hutool.db.sql.Order;
import com.fasterxml.jackson.databind.ObjectReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname OrderConsulMain80
 * @Description TODO
 * @Date 2022/1/31 19:15
 * @Created by LQQ
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class, args);
    }
}
