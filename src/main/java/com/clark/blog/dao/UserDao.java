package com.clark.blog.dao;

import com.clark.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: ClarkRao
 * @Date: 2019/4/5 21:04
 * @Description:
 */
@Repository
public interface UserDao extends JpaRepository<User,Long> {

    User findUserByUserName(String userName);
}
