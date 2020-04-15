package com.soft1851.springboot.aop.service.Impl;

import com.soft1851.springboot.aop.entity.SysUser;
import com.soft1851.springboot.aop.mapper.SysUserMapper;
import com.soft1851.springboot.aop.mapper.UserRoleMapper;
import com.soft1851.springboot.aop.service.SysUserService;
import com.soft1851.springboot.aop.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/14 12:00
 * @Version 1.0
 **/
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public Map<String,Object> signIn(String id, String password) {
        SysUser user = sysUserMapper.signIn(id);
        Map<String,Object> map = null;
        String pass = MD5Util.getMD5(password, 32);
        if(user != null && user.getPassword().equals(pass)){
            map = userRoleMapper.getUserRole(id);
            if(map != null) {
                return map;
            }
        }
        map.put("msg", "账号密码错误");
        return map;
    }
}
