package com.guo.gmall.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.filter.OrderedFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.RequestPath;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Date: 2021/3/25 17:39
 * @Author 郭乐建
 * @Since JDK 1.8
 * @Description:
 */
@Component
public class CommonFilter implements GlobalFilter, Ordered {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        long startTime = System.currentTimeMillis();
        String uri = exchange.getRequest().getPath().toString();

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            long endTime = System.currentTimeMillis();
            logger.info("======================>{}: {}ms", uri, (endTime - startTime));
        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
