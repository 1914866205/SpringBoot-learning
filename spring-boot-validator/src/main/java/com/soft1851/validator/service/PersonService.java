package com.soft1851.validator.service;

import com.soft1851.validator.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/30 17:45
 * @Version 1.0
 **/
@Slf4j
@Service
@Validated
public class PersonService {
    public void validatePerson(@Validated Person person) {
        log.info("service方法验证");
    }
}
