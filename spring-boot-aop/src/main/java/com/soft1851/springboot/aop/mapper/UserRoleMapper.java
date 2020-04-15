package com.soft1851.springboot.aop.mapper;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/14 11:58
 * @Version 1.0
 **/
public interface UserRoleMapper {


    @Results({
            @Result(property = "role", column = "role_id",
            one=@One(select = "com.soft1851.springboot.aop.mapper.SysRoleMapper.SysRoleById")),
            @Result(property = "user",column = "user_id",
            one = @One(select = "com.soft1851.springboot.aop.mapper.SysUserMapper.getUserById"))
    })
    @Select("SELECT * FROM sys_role WHERE user_id=#{userId}")
    Map<String, Object> getUserRole(String userId);
}
