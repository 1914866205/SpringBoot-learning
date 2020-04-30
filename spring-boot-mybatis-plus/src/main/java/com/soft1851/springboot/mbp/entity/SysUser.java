package com.soft1851.springboot.mbp.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2020-04-16 09:40:45
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysUser implements Serializable {
    private static final long serialVersionUID = -37750954218731380L;
    /**
    * 主键
    */
    private Integer userId;
    
    private String userName;
    
    private String password;
    
    private String salt;
    
    private String email;
    
    private String phoneNumber;
    
    private Integer status;
    
    private Integer binding;
    
    private Integer credits;
    
    private Timestamp createTime;
    
    private Timestamp lastLoginTime;

}