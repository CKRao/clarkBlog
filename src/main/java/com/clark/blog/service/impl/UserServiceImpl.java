package com.clark.blog.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.clark.blog.dao.*;
import com.clark.blog.entity.*;
import com.clark.blog.entity.enumType.RoleType;
import com.clark.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: ClarkRao
 * @Date: 2019/4/5 21:26
 * @Description: 用户服务实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public User findUserById(Long id) {
        return userDao.findById(id).get();
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    @Override
    public Page<User> findUsers(Pageable pageable) {
        return userDao.findAll(pageable);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    @Override
    public User insertUser(User user) {
        return userDao.save(user);
    }

    @Override
    public List<Role> selectRoleByUser(User user) {

        if (ObjectUtil.isNull(user)) {
            throw new NullPointerException("user is null");
        }

        List<Long> roleIds = userRoleDao.findByUserId(user.getId())
                .stream()
                .map(UserRole::getRoleId)
                .collect(Collectors.toList());

        return roleDao.findAllById(roleIds);
    }

    @Override
    public List<Permission> selectPermissionByRole(Role role) {
        if (ObjectUtil.isNull(role)) {
            throw new NullPointerException("role is null");
        }

        List<Long> permissionIds = rolePermissionDao.findAllByRoleId(role.getId()).stream()
                .map(RolePermission::getPermissionId)
                .collect(Collectors.toList());
        return permissionDao.findAllById(permissionIds);
    }

    @Override
    public void initUserRole(RoleType roleType, User user) {
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        Role role = roleDao.findByRole(roleType);
        userRole.setRoleId(role.getId());
        userRoleDao.save(userRole);
    }


}
