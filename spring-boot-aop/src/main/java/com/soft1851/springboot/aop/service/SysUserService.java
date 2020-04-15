package com.soft1851.springboot.aop.service;

import java.util.Map;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/14 11:59
 * @Version 1.0
 **/
public interface SysUserService {

    /**
     * 用户登录
     * @param id
     * @param password
     * @return
     */
    Map<String, Object> signIn(String id, String password);
}
