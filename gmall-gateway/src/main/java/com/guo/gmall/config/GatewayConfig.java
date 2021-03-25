package com.guo.gmall.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Date: 2021/3/25 14:24
 * @Author 郭乐建
 * @Since JDK 1.8
 * @Description:
 */
@Configuration
public class GatewayConfig {

    // 路由配置dataId
    public static String NACOS_ROUTE_DATA_ID;

    // 路由配置组id
    public static String NACOS_ROUTE_GROUP_ID;

    // nacos配置中心地址
    public static String NACOS_SERVER_ADDR;

    // nacos namespace
    public static String NACOS_NAMESPACE;

    // 获取动态路由配置超时时间
    public static long DEFAULT_TIMEOUT = 30000;

    @Value("${gateway.dynamicRoute.dataId}")
    public void setNacosDataId(String dataId) {
        NACOS_ROUTE_DATA_ID = dataId;
    }

    @Value("${gateway.dynamicRoute.group}")
    public void setNacosGroupId(String group) {
        NACOS_ROUTE_GROUP_ID = group;
    }

    @Value("${spring.cloud.nacos.discovery.server-addr}")
    public void setServerAddr(String serverAddr) {
        NACOS_SERVER_ADDR = serverAddr;
    }

    @Value("${gateway.dynamicRoute.namespace}")
    public void setNacosNamespace(String namespace) {
        NACOS_NAMESPACE = namespace;
    }
}
