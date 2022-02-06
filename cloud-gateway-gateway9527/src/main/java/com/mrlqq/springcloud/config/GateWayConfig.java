package com.mrlqq.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname GateWayConfig
 * @Description TODO
 * @Date 2022/2/6 12:37
 * @Created by LQQ
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouterLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        // 映射https://news.baidu.com/guonei
        routes.route("path_route_mrlqq", r -> r.path("/guonei").uri("https://news.baidu.com/guonei")).build();
        // https://news.baidu.com/guoji
        routes.route("path_route_mrlqq1", r -> r.path("/guoji").uri("https://news.baidu.com/guoji")).build();

        return routes.build();
    }
}
