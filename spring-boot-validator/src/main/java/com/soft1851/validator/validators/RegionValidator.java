package com.soft1851.validator.validators;

import com.soft1851.validator.annoration.Region;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description 自定义校验规则
 * @Author 涛涛
 * @Date 2020/4/30 17:55
 * @Version 1.0
 **/
public class RegionValidator implements ConstraintValidator<Region, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        HashSet<Object> regions = new HashSet<>();
        regions.add("China");
        regions.add("China-TaiWan");
        regions.add("China-HongKong");
        return regions.contains(s);
    }
}
