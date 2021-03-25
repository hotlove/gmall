package com.guo.gmall.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guo.gmall.common.CommonResult;
import com.guo.gmall.feign.UserAuthService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date: 2021/3/25 17:39
 * @Author 郭乐建
 * @Since JDK 1.8
 * @Description:
 */
@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Resource
    private UserAuthService userAuthService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String token = exchange.getRequest().getQueryParams().getFirst("token");
        CommonResult commonResult = userAuthService.checkToken(token);
        if (commonResult.getCode().intValue() == 0) {
            return chain.filter(exchange);
        } else {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return errorInfo(exchange, "用户会话无效", 8001);
        }
    }

    public static Mono<Void> errorInfo(ServerWebExchange exchange, String message, Integer status) {
        // 自定义返回格式
        Map<String, Object> resultMap = new HashMap<>(8);
        resultMap.put("status", status == null ? 2 : status);
        resultMap.put("message", StringUtils.isBlank(message) ? "服务异常！" : message);
        resultMap.put("info", null);
        resultMap.put("data", null);
        return Mono.defer(() -> {
            byte[] bytes = null;
            try {
                bytes = new ObjectMapper().writeValueAsBytes(resultMap);
            } catch (Exception e) {
            }
            ServerHttpResponse response = exchange.getResponse();
            response.getHeaders().add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
            DataBuffer buffer = response.bufferFactory().wrap(bytes);
            return response.writeWith(Flux.just(buffer));
        });
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
