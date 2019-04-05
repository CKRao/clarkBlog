package com.clark.blog.controller;

import com.clark.blog.entity.ResponseBean;
import com.clark.blog.entity.User;
import com.clark.blog.exception.UnauthorizedException;
import com.clark.blog.service.UserService;
import com.clark.blog.util.Encrypt;
import com.clark.blog.util.JWTUtil;
import com.clark.blog.util.ValidateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author: ClarkRao
 * @Date: 2019/4/5 22:24
 * @Description: 用户控制器
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("login")
    public ResponseBean login(@RequestParam("userName") String userName,
                              @RequestParam("password") String password) {
        //通过用户名和加密的密码去查找用户
        String passwordEncrypt = Encrypt.passwordEncrypt(password);
        User user = userService.findUserByUserName(userName);
        //如果用户存在，则返回响应
        if (ValidateUtil.isNotEmpty(user) && passwordEncrypt.equals(user.getPassword())) {
            return new ResponseBean(200, "Login success", JWTUtil.sign(userName, passwordEncrypt));
        }
        //否则抛出异常
        throw new UnauthorizedException();
    }

    @PostMapping("register")
    public ResponseBean register(@RequestBody User user) {
        String password = Encrypt.passwordEncrypt(user.getPassword());
        user.setPassword(password);
        user.setCreateTime(new Date());
        User save = userService.insertUser(user);
        if (ValidateUtil.isNotEmpty(save)) {
            return new ResponseBean(200, "Register success", null);
        }

        return new ResponseBean(500, "Register failed", null);
    }


    @GetMapping("test")
    public ResponseBean test() {
        return new ResponseBean(500, "test", null);
    }
}
