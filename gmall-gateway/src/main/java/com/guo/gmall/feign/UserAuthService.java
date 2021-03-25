package com.guo.gmall.feign;

import com.guo.gmall.common.CommonResult;
import com.guo.gmall.feign.fallback.UserAuthServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "gmall-user-auth", fallback = UserAuthServiceImpl.class)
public interface UserAuthService {

    @GetMapping("/gmall/profile/auth/check/token/{token}")
    CommonResult checkToken(@PathVariable("token") String token);
}
