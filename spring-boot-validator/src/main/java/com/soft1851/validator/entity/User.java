package com.soft1851.validator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/30 18:04
 * @Version 1.0
 **/
@Data
public class User {
    @NotNull(message = "用户id不能为空")
    private Long id;

    @Size(min=6,max = 10,message = "账号长度必须是6-11个字符")
    @NotNull(message="用户账号不能为空")
    private String account;

    @NotNull(message = "用户密码不能为空")
    @Size(min=6,max=11,message="密码长度必须是6-16个字符串")
    private String password;

    @NotNull(message = "用户邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;


}
