package com.guo.gmall.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/3/24 16:37
 * @Author 郭乐建
 * @Since JDK 1.8
 * @Description:
 */
@RestController
@RequestMapping("/gmall/profile")
public class ProfileController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
