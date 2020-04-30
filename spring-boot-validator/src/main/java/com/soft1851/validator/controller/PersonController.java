package com.soft1851.validator.controller;

import com.soft1851.validator.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Description 使用Spring框架自带的ResponseEntity作为返回值
 * @Author 涛涛
 * @Date 2020/4/30 17:11
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api")
@Slf4j
@Validated//该注解会告诉SpringBoot去校验方法中的参数
public class PersonController {
    @RequestMapping("/person")
    public ResponseEntity<Person> savePerson(@RequestBody @Valid Person person) {
        return ResponseEntity.ok().body(person);
    }
}
