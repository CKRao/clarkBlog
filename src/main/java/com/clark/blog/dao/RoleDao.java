package com.clark.blog.dao;

import com.clark.blog.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: ClarkRao
 * @Date: 2019/8/20 22:44
 * @Description:
 */
public interface RoleDao extends JpaRepository<Role,Long> {

}
