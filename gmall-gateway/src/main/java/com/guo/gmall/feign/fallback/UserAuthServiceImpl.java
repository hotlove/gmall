package com.guo.gmall.feign.fallback;

import com.guo.gmall.common.CommonResult;
import com.guo.gmall.feign.UserAuthService;

/**
 * @Date: 2021/3/25 19:55
 * @Author 郭乐建
 * @Since JDK 1.8
 * @Description:
 */
public class UserAuthServiceImpl implements UserAuthService {
    @Override
    public CommonResult checkToken(String token) {
        return CommonResult.error(false);
    }
}
