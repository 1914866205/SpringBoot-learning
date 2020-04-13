package com.soft1851.springboot.aop.controller;

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
public class User implements Serializable {
    private static final long serialVersionUID = -10493903982420480L;
    
    private String userId;

    private String emailFlag;

    private String phoneNumber;

    private String phoneNumberFlag;

    private String fullName;

    private String studentNo;

    private String avatarUrl;

    private Date joinTime;

    private String clazzCourseId;

    private Integer score;

    private String roles;

    private Integer ranking;


//    private int studentId;
//    private int clazzId;
//    private String studentName;
//    private String hometown;
////    private LocalDate birthday;
}