package com.soft1851.springboot.aop.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (SysPermission)实体类
 *
 * @author makejava
 * @since 2020-04-14 11:25:21
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysPermission implements Serializable {
    private static final long serialVersionUID = -51645557415467799L;
    /**
    * 权限id
    */
    private Integer pId;
    /**
    * 父类id
    */
    private Integer parentId;
    /**
    * 权限名称
    */
    private String pName;
    /**
    * 类型
    */
    private Integer type;
    /**
    * 图标
    */
    private String icon;
    /**
    * 地址
    */
    private String path;
    /**
    * 扩展字段1
    */
    private String ex1;
    /**
    * 扩展字段2
    */
    private Integer ex2;


    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getEx1() {
        return ex1;
    }

    public void setEx1(String ex1) {
        this.ex1 = ex1;
    }

    public Integer getEx2() {
        return ex2;
    }

    public void setEx2(Integer ex2) {
        this.ex2 = ex2;
    }

}