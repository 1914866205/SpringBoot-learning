package com.soft1851.springboot.aop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-04-07 13:15:38
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String id;
    private String name;
    private String role;

}