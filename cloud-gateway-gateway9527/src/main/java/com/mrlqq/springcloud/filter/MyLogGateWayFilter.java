package com.mrlqq.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @Classname MyLogGateWayFilter
 * @Description TODO
 * @Date 2022/2/6 16:09
 * @Created by LQQ
 */

@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

    /**
     * 过滤请求，查看请求中的uname是否有效
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("******come in MyLogGateWayFIlter:" + new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname == null){
            log.info("*****用户名为null，非法用户");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * getOrder表示加载过滤器的顺序，越小优先级越高
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
