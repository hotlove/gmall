package com.guo.cache.executor;

public interface CacheExecutor {

    boolean setKeyValue(String key, String value);

    boolean getValueByKey(String key);
}
