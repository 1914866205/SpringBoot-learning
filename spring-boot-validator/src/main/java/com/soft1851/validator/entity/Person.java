package com.soft1851.validator.entity;

import com.soft1851.validator.annoration.Phone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.*;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/30 17:01
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @NotNull(message = "Id不能为空")
    @Size(min = 6,max = 10)
    private String id;

    @Size(max=10)
    @NotNull(message="name不能为空")
    private String name;

    @Min(18)
    private Integer age;

    @Pattern(regexp = "^[1](([3|5|8][\\\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\\\d]{8}$",message = "手机号码格式错误")
    @Phone(message = "手机号码格式错误")
    @NotBlank(message ="手机号码不能为空")
    private String phone;

    @NotNull(message = "email 不能为空")
    @Email(message = "邮箱格式错误")
    private String email;

    @Pattern(regexp = "((^Man$|^Woman$|^UGM$))",message = "sex值不在可选范围")
    @NotNull(message = "sex不能为空")
    private String sex;

}
