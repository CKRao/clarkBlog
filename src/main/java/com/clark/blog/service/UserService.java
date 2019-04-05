package com.clark.blog.service;

import com.clark.blog.entity.User;
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
     * @param password
     * @return
     */
    User findUserByUserNameAndPassword(String userName, String password);

    void inserUser(User user);

}
