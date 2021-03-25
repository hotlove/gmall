package com.guo.gmall.controller;

import com.guo.gmall.common.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Date: 2021/3/24 16:37
 * @Author 郭乐建
 * @Since JDK 1.8
 * @Description:
 */
@RestController
@RequestMapping("/gmall/profile/base")
public class ProfileController {

    @GetMapping("/test")
    public CommonResult test() throws InterruptedException {
        return CommonResult.success("test");
    }
}
