package com.clark.blog;

import com.clark.blog.dao.RoleDao;
import com.clark.blog.dao.UserDao;
import com.clark.blog.dao.UserRoleDao;
import com.clark.blog.entity.Role;
import com.clark.blog.entity.User;
import com.clark.blog.entity.UserRole;
import com.clark.blog.entity.enumType.RoleType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Autowired
    RoleDao roleDao;

    @Autowired
    UserDao userDao;

    @Autowired
    UserRoleDao userRoleDao;
    @Test
    public void contextLoads() {
    }

    @Test
    public void testRole() {
        Role role = new Role();
        role.setRole(RoleType.ROLE_ADMIN);
        roleDao.save(role);

        Role role2 = new Role();
        role2.setRole(RoleType.ROLE_USER);
        roleDao.save(role2);

        User clark = userDao.findUserByUserName("clark");

        UserRole userRole = new UserRole();

        userRole.setRoleId(role.getId());
        userRole.setUserId(clark.getId());

        userRoleDao.save(userRole);

    }
}
