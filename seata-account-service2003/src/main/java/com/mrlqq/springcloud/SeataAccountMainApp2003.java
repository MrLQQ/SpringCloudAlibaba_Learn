package com.mrlqq.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname SeataAccountMainApp2003
 * @Description TODO
 * @Date 2022/2/11 21:29
 * @Created by LQQ
 */
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.mrlqq.springcloud.dao")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)   //取消数据源自动创建
public class SeataAccountMainApp2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountMainApp2003.class, args);
    }
}
