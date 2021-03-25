package com.guo.gmall.controller;

import com.guo.gmall.common.CommonResult;
import org.springframework.web.bind.annotation.*;

/**
 * @Date: 2021/3/25 16:46
 * @Author 郭乐建
 * @Since JDK 1.8
 * @Description:
 */
@RestController
@RequestMapping("/gmall/profile/auth")
public class AuthController {

    @GetMapping("/test")
    public String test() {
        return "auth test";
    }

    @GetMapping("/check/token/{token}")
    public CommonResult checkToken(@PathVariable("token") String token) {
        if ("123".equals(token)) {
            return CommonResult.success(true);
        }
        return CommonResult.error(false);
    }
}
