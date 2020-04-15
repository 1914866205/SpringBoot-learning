package com.soft1851.springboot.aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/13
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping("/g")
    public String get() {
        return "123";
    }
}
