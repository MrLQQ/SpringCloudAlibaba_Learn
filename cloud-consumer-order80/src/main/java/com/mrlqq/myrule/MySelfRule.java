package com.mrlqq.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.aspectj.weaver.reflect.IReflectionWorld;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname MySelfRule
 * @Description TODO
 * @Date 2022/2/2 15:38
 * @Created by LQQ
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        // 定义随机选择
        return new RandomRule();
    }
}
