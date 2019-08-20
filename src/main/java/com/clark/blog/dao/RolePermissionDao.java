package com.clark.blog.dao;

import com.clark.blog.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: ClarkRao
 * @Date: 2019/8/20 23:22
 * @Description:
 */
public interface RolePermissionDao extends JpaRepository<RolePermission,Long> {

    /**
     * 根据roleId查找所有权限Id
     * @param roleId
     * @return
     */
    List<RolePermission> findAllByRoleId(Long roleId);

}
