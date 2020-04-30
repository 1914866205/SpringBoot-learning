package com.soft1851.springboot.mbp.model;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ntt
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysPermission implements Serializable {

    private static final long serialVersionUID = 1L;

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


}
