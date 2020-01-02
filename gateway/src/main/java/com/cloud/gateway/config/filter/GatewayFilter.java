package com.cloud.gateway.config.filter;

import com.alibaba.fastjson.JSON;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class GatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders headers = exchange.getRequest().getHeaders();
        // 此处写死了，演示用，实际中需要采取配置的方式
        if (getIp(headers).equals("localhost")) {
            ServerHttpResponse response = exchange.getResponse();
            Map<Object, Object> map = new ConcurrentHashMap<>();
            map.put("code", 401);
            map.put("message", "非法请求");
            /*ResponseData data = new ResponseData();
            data.setCode(401);
            data.setMessage("非法请求");*/
            byte[] datas = JSON.toJSONString(map).getBytes(StandardCharsets.UTF_8);
            /*byte[] datas = JsonUtils.toJson(data).getBytes(StandardCharsets.UTF_8);*/
            DataBuffer buffer = response.bufferFactory().wrap(datas);
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
            return response.writeWith(Mono.just(buffer));
        }
        return chain.filter(exchange);
    }

    // 这边从请求头中获取用户的实际IP,根据Nginx转发的请求头获取
    private String getIp(HttpHeaders headers) {
        String hostName = headers.getHost().getHostName();
        return hostName;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
