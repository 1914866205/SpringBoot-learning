package com.soft1851.springboot.aop.service.Impl;

import com.soft1851.springboot.aop.mapper.RolePermissionMapper;
import com.soft1851.springboot.aop.mapper.SysPermissionMapper;
import com.soft1851.springboot.aop.service.RolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/14 12:00
 * @Version 1.0
 **/
@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Resource
    private RolePermissionMapper rolePermissionMapper;
    @Resource
    private SysPermissionMapper sysPermissionMapper;
    @Override
    public List<Map<String, Object>> getAdminRolePermission() {
        return sysPermissionMapper.getParentPermission();
    }

    @Override
    public List<Map<String, Object>> getRolePermissionBySysAdmin(int sysAdminId) {
        return rolePermissionMapper.getRoleById(sysAdminId);
    }
}
