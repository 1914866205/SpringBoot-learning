package com.soft1851.springboot.aop.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @Description 根据角色id查询角色
 * @Author 涛涛
 * @Date 2020/4/14 11:57
 * @Version 1.0
 **/
public interface SysRoleMapper {
    @Select("SELECT * FROM sys_role WHERE role_id=#{roleId})")
    Map<String, Object> getRoleById(int roleId);
}
