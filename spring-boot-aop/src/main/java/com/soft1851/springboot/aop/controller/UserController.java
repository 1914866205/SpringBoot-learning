package com.soft1851.springboot.aop.controller;

import com.soft1851.springboot.aop.annotation.AuthToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/13 15:21
 * @Version 1.0
 **/
@RestController
@Slf4j
public class UserController {

    /**
     * 无需任何校验，不要加注解
     * @param name
     * @return
     */
    @GetMapping("hello")
    public String hello(String name) {
        log.info("hello()无需鉴权,也无需认证,当前用户名：" + name);
        return "hello方法访问成功";
    }


    /**
     * 需要认证，此时该方法需要加注解，但是不需要传角色
     * @param name
     * @return
     */
    @GetMapping("user")
    @AuthToken
    public String user(String name) {
//        log.info("user()需要认证,当前用户名：" + name);
        log.info("班级成员需要认证,当前用户名：" + name);
//        return "user()方法访问成功";
        return "班级成员访问成功";
    }

    /**
     * 需要鉴权，此时该方法需要加注解，但是不需要传角色
     * 角色可以传多个
     * 如果需要更复杂的逻辑操作，建议使用Spring Security,Apache Shiro等安全框架
     * @param name
     * @return
     */
    @GetMapping("admin")
    @AuthToken(role_name = {"admin","Admin"})
    public String admin(String name) {
//        log.info("admin()需要鉴权,当前用户名：" + name);
        log.info("助教需要鉴权,当前用户名：" + name);
        return "admin()方法访问成功";
    }
}
