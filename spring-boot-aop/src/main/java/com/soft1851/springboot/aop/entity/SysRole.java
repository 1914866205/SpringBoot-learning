package com.soft1851.springboot.aop.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (SysRole)实体类
 *
 * @author makejava
 * @since 2020-04-14 11:25:21
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysRole implements Serializable {
    private static final long serialVersionUID = -50336545456425864L;
    /**
    * 角色id
    */
    private Integer roleId;
    /**
    * 角色名词
    */
    private String roleName;
    /**
    * 描述
    */
    private String description;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}