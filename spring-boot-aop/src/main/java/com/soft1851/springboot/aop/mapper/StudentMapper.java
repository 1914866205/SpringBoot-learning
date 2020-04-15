package com.soft1851.springboot.aop.mapper;

import com.soft1851.springboot.aop.entity.Student;
import com.soft1851.springboot.aop.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/7 13:16
 * @Version 1.0
 **/
public interface StudentMapper {
    /**
     * 查询所有用户
     * @return
     */
    @Select("SELECT * FROM db_ntt.t_student")
    List<Student> selectAll();


    /**
     * 通过学号查询用户
     * @return
     */
    @Select("SELECT * FROM db_ntt.t_student WHERE id = #{id}")
    Student getStudentById(String id);

}
