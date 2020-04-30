package com.soft1851.springboot.mbp.mapper;

import com.soft1851.springboot.mbp.model.SysPermission;
import com.soft1851.springboot.mbp.model.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ntt
 * @since 2020-04-16
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {
    /**
     *根据用户id查询权限
     * @return
     */
    List<SysPermission> getUserPermissionById(Integer id);
}
