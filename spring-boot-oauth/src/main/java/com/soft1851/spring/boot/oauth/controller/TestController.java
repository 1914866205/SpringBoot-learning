package com.soft1851.spring.boot.oauth.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/29 10:58
 * @Version 1.0
 **/
@RestController
public class TestController {
    @RequestMapping("/index")
    public String simpleIndex() {
        return "index";
    }
}
