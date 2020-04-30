package com.soft1851.validator.controller;

import com.soft1851.validator.entity.User;
import com.soft1851.validator.service.UserService;
import com.soft1851.validator.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/30 18:02
 * @Version 1.0
 **/
@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody @Valid User user) {
//    public String addUser(@RequestBody @Valid User user, BindingResult bind) {
        //如果有参数校验失败，会将错误信息封装成对象组装在BindingResult里
//        for (ObjectError error : bind.getAllErrors()) {
//            return error.getDefaultMessage();
//        }
        return userService.addUser(user);
    }

    @GetMapping("/getUser")
    public User getUser(){
//    public ResultVO<User> getUser(){
        User user = new User();
        user.setId(1L);
        user.setAccount("21212212");
        user.setPassword("21212212");
        user.setEmail("121212.qq.com");
//        return new ResultVO<>(user);
        return user;
    }
}
