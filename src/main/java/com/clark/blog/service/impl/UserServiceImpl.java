package com.clark.blog.service.impl;

import com.clark.blog.dao.UserDao;
import com.clark.blog.entity.User;
import com.clark.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ClarkRao
 * @Date: 2019/4/5 21:26
 * @Description: 用户服务实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findUserById(Long id) {
        User user = userDao.findById(id).get();
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = userDao.findAll();
        return users;
    }

    @Override
    public Page<User> findUsers(Pageable pageable) {
        Page<User> userPage = userDao.findAll(pageable);
        return userPage;
    }

    @Override
    public User findUserByUserName(String userName) {
        User user = userDao.findUserByUserName(userName);
        return user;
    }

    @Override
    public User insertUser(User user) {
        User save = userDao.save(user);
        return save;
    }


}
