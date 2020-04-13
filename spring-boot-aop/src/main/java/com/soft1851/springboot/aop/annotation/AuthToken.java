package com.soft1851.springboot.aop.annotation;


import java.lang.annotation.*;

/**
 * 认证鉴权注解
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthToken {

    /**
     * 访问接口所需要的身份，默认为空
     * 即登录即可访问
     * 可以定义多个
     * @return String[]
     */
    String[] role_name() default "";
}
