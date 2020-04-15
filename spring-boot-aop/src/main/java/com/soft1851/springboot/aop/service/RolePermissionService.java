package com.soft1851.springboot.aop.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/14 11:59
 * @Version 1.0
 **/
public interface RolePermissionService {
    /**
     * 查询超管权限
     *
     * @return
     */
    List<Map<String, Object>> getAdminRolePermission();


    /**
     *
     * 查询管理员权限
     * @param sysAdminId
     * @return
     */
    List<Map<String, Object>> getRolePermissionBySysAdmin(int sysAdminId);
}
