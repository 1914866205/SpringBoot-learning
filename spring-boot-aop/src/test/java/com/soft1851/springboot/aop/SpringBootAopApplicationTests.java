package com.soft1851.springboot.aop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootTest
class SpringBootAopApplicationTests {
    @Resource
    private DataSource dataSource;
    @Test
    void contextLoads() {
        System.out.println(dataSource);
    }
}
