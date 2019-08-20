package com.clark.blog.dao;

import com.clark.blog.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: ClarkRao
 * @Date: 2019/8/20 23:03
 * @Description:
 */
public interface UserRoleDao extends JpaRepository<UserRole,Long> {
    /**
     * 根据userId查找角色id列表
     * @param userId
     * @return
     */
    List<UserRole> findByUserId(Long userId);
}
