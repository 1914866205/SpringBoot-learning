package com.soft1851.springboot.aop.controller;

import com.soft1851.springboot.aop.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void selectAll() {
        System.out.println(userMapper.selectAll());
    }
}