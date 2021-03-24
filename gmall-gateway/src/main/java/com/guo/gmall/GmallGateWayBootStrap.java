package com.guo.gmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Date: 2021/3/24 16:29
 * @Author 郭乐建
 * @Since JDK 1.8
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GmallGateWayBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(GmallGateWayBootStrap.class, args);
    }
}
