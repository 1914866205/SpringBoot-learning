package com.soft1851.validator.service;

import com.soft1851.validator.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.annotation.Validated;

import javax.validation.*;
import java.io.PipedReader;
import java.util.Set;

@SpringBootTest
@Validated
class PersonServiceTest {
    @Autowired
    private PersonService personService;
    @Test
    void validatePerson() {
        //创建对象
        Person person = new Person();
        person.setId("123456");
        person.setName("ntt");
        person.setAge(20);
        person.setPhone("18851855106");
        person.setEmail("1914866205@qq.com");
        person.setSex("Man");
        personService.validatePerson(person);
    }

    @Test
    void  checkManually(){
        //通过Validator 工厂类获得的Validator实例，也可以通过注入的方式
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        //创建对象
        Person person = new Person();
        person.setId("12345slhghsgkhskgns6");
        person.setName("naaaaaaaaaaaaaaaaaaaaaaaaatt");
        person.setAge(2);
        person.setPhone("106");
        person.setEmail("19m");
        //对参数进行校验，得到一组结果
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        for (ConstraintViolation<Person> constraintViolation : violations) {
            System.out.println(constraintViolation.getMessage());
        }
    }
}