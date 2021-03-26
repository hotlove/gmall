package com.guo.cache.service.impl;

import com.guo.cache.executor.CacheManager;
import com.guo.cache.service.CacheService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Date: 2021/3/26 14:57
 * @Author 郭乐建
 * @Since JDK 1.8
 * @Description:
 */
@Service
public class CacheServiceImpl implements CacheService {

    @Resource
    private CacheManager cacheManager;


}
