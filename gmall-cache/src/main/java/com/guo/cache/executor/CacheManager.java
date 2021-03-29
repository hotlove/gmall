package com.guo.cache.executor;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Date: 2021/3/26 16:44
 * @Author 郭乐建
 * @Since JDK 1.8
 * @Description:
 */
@Component
public class CacheManager {

    @Resource
    private CacheExecutor cacheExecutor;

    public CacheExecutor getCacheExecutor() {
        return cacheExecutor;
    }
}
