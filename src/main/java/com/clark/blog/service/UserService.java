package com.clark.blog.service;

import com.clark.blog.entity.Permission;
import com.clark.blog.entity.Role;
import com.clark.blog.entity.User;
import com.clark.blog.entity.enumType.RoleType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: ClarkRao
 * @Date: 2019/4/5 21:05
 * @Description: 用户服务接口
 */
public interface UserService {

    /**
     * 根据id查找
     * @param id
     * @return
     */
    User findUserById(Long id);

    /**
     * 查找所有的用户
     * @return
     */
    List<User> findAllUsers();

    /**
     * 分页查找用户
     * @param pageable
     * @return
     */
    Page<User> findUsers(Pageable pageable);

    /**
     * 根据用户名和密码查找
     * @param userName
     * @return
     */
    User findUserByUserName(String userName);

    /**
     * 插入用户
     * @param user
     * @return
     */
    User insertUser(User user);

    /**
     * 根据用户查找角色
     * @param user
     * @return
     */
    List<Role> selectRoleByUser(User user);

    /**
     * 根据角色查找权限列表
     * @param role
     * @return
     */
    List<Permission> selectPermissionByRole(Role role);

    void initUserRole(RoleType roleType, User user);
}
