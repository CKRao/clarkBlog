package com.clark.blog.dao;

import com.clark.blog.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: ClarkRao
 * @Date: 2019/8/20 23:25
 * @Description:
 */
public interface PermissionDao extends JpaRepository<Permission,Long> {
}
