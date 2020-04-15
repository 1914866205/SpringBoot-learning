package com.soft1851.springboot.aop.controller;

import com.soft1851.springboot.aop.annotation.AuthToken;
import com.soft1851.springboot.aop.common.Result;
import com.soft1851.springboot.aop.service.RolePermissionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (RolePermission)表控制层
 *
 * @author makejava
 * @since 2020-04-13 19:51:02
 */
@RestController
@RequestMapping(value = "/rolePermission")
public class RolePermissionController {

    @Resource
    private RolePermissionService service;

    @GetMapping("/admin")
    @AuthToken(role_name = "超级管理员")
    public Result selectAll(@Param("id") int id) {
        return Result.success(service.getAdminRolePermission());
    }

    @GetMapping("/sysAdmin")
    @AuthToken(role_name = {"超级管理员","系统管理员"})
    public Result getBySysId(@Param("id") int id) {
        return Result.success(service.getRolePermissionBySysAdmin(id));
    }

}