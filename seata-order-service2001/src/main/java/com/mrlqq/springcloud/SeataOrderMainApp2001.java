package com.mrlqq.springcloud;

import com.mrlqq.springcloud.config.DataSourceProxyConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname SeataOrderMainApp2001
 * @Description TODO
 * @Date 2022/2/11 21:29
 * @Created by LQQ
 */
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.mrlqq.springcloud.dao")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)   //取消数据源自动创建
public class SeataOrderMainApp2001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMainApp2001.class, args);
    }
}
