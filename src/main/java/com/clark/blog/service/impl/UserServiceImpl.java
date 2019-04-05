package com.clark.blog.service.impl;

import com.clark.blog.dao.UserDao;
import com.clark.blog.entity.User;
import com.clark.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: ClarkRao
 * @Date: 2019/4/5 21:26
 * @Description:
 */
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
    public User findUserByUserNameAndPassword(String userName, String password) {
        User user = userDao.findUserByUserNameAndPassword(userName, password);
        return user;
    }

    @Override
    public void inserUser(User user) {
        User save = userDao.save(user);
        
    }


}
