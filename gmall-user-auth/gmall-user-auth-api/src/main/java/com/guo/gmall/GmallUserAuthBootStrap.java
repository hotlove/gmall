package com.guo.gmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Date: 2021/3/24 16:35
 * @Author 郭乐建
 * @Since JDK 1.8
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GmallUserAuthBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(GmallUserAuthBootStrap.class, args);
    }
}
