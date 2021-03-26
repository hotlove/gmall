package com.guo.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Date: 2021/3/26 14:53
 * @Author 郭乐建
 * @Since JDK 1.8
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GmallCacheBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(GmallCacheBootStrap.class, args);
    }
}
