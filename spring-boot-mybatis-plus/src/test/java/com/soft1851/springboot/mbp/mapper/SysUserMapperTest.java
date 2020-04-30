package com.soft1851.springboot.mbp.mapper;

import com.soft1851.springboot.mbp.entity.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.Timestamp;

@SpringBootTest
class SysUserMapperTest {

    @Resource
    private SysUserMapper sysUserMapper;

//    @Test
//    void getAllUser() {
//        System.out.println(sysUserMapper.getAllUser());
//    }
//
//    @Test
//    public void insert(){
//        SysUser sysUser = SysUser.builder()
//                .userId(10)
//                .userName("胖")
//                .salt("11cjlkvnjkbgjbhlfsh")
//                .password("123")
//                .createTime(new Timestamp(System.currentTimeMillis()))
//                .build();
//        sysUserMapper.insert(sysUser);
//    }
//
//    @Test
//    public void deleteById(){
//        sysUserMapper.deleteById(10);
//    }
    @Test
    public void selectById(){
        System.out.println(sysUserMapper.selectById(11));
    }
//    @Test
//    public void selectAll(){
//        System.out.println(sysUserMapper.selectList(null));
//    }
}