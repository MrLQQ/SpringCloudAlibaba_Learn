package com.mrlqq.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Classname LoadBalancer
 * @Description TODO
 * @Date 2022/2/2 16:37
 * @Created by LQQ
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
