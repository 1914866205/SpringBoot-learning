package com.soft1851.validator.service;

import com.soft1851.validator.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/30 18:26
 * @Version 1.0
 **/
@Slf4j
@Service
public class UserService {
    public String addUser(User user) {
        //直接编写业务逻辑
        return "success";
    }
}
