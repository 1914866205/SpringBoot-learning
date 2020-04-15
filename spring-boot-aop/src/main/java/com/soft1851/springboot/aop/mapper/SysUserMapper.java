package com.soft1851.springboot.aop.mapper;

import com.soft1851.springboot.aop.entity.SysUser;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/14 11:57
 * @Version 1.0
 **/
public interface SysUserMapper {


    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    @Select("SELECT t1.*,t2.*"+
            "FROM user_role t3 "+
            "LEFT JOIN sys_user t1" +
            "ON t1.user_id=t3.user_id"+
            "LEFT JOIN sys_role t2"+
            "ON t2.role_id=t3.role_id"+
            "WHERE t3.user_id=#{userId}")
    Map<String, Object> getUserById(String userId);

    @Select("SELECT * FROM sys_user WHERE user_id=#{userId}")
    SysUser signIn(String userId);

}
