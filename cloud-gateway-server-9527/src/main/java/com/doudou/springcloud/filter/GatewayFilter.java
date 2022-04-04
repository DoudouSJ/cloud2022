package com.doudou.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Doudou
 * @date 2022/3/24 - 9:58
 */
@Component
@Slf4j
public class GatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("exchange-{}",exchange.getRequest().getPath());
        log.info("exchange-{}",exchange.getRequest().getLocalAddress());
        log.info("exchange-{}",exchange.getRequest().getBody().toString());
        log.info("exchange-{}",exchange.getRequest().getURI().toString());
        log.info("exchange-{}",exchange.getRequest().getHeaders().toString());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
