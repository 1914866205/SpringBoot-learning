package com.soft1851.springboot.aop.mapper;

import com.soft1851.springboot.aop.entity.SysPermission;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/14 11:57
 * @Version 1.0
 **/
public interface SysPermissionMapper {

    /**
     * 根据资源id查询
     * @param id
     * @return
     */
    @Select("SELECT * FROM sys_permission WHERE p_id=#{id}")
    SysPermission getPermissionById(String id);


    /**
     * 根据资源id查询资源及子类型
     * @param id
     * @return
     */
    @Results({
            @Result(property = "p_id", column = "p_id"),
            @Result(property = "subList" ,column = "p_id",
                    many= @Many(select = "com.soft1851.springboot.aop.mapper.SysPermissionMapper.getPermissionByParentId"))
    })
    @Select("SELECT * FROM sys_permission WHERE p_id=#{id}")
    Map<String, Object> getChildPermissionById(String id);


    /**
     * 获取也能资源及其所拥有的子类资源
     * @return
     */
    @Results({
            @Result(property = "p_id",column = "p_id"),
            @Result(property = "subList",column = "p_id",
            many=@Many(select = "com.soft1851.springboot.aop.mapper.SysPermissionMapper.getPermissionByParentId"))
    })
    @Select("SELECT * FROM sys_permission WHERE parent_id=0")
    List<Map<String,Object>> getParentPermission();



    @Results({
        @Result(property = "p_id",column = "p_id"),
        @Result(property = "subList" ,column = "p_id",
        many=@Many(select = "com.soft1851.springboot.aop.mapper.SysPermissionMapper.getPermissionByParentId"))
    })
    @Select("SELECT * FROM sys_permission WHERE parent_id=#{parent}")
    List<Map<String,Object>> getPermissionByParentId(int parent);
}
