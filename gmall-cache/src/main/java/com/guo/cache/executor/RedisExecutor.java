package com.guo.cache.executor;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Date: 2021/3/26 16:45
 * @Author 郭乐建
 * @Since JDK 1.8
 * @Description:
 */
@Service
public class RedisExecutor implements CacheExecutor{

    @Resource
    private CacheExecutor cacheExecutor;
}
