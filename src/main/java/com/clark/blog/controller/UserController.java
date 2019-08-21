package com.clark.blog.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpStatus;
import com.clark.blog.entity.ResponseBean;
import com.clark.blog.entity.User;
import com.clark.blog.exception.UnauthorizedException;
import com.clark.blog.service.UserService;
import com.clark.blog.util.Encrypt;
import com.clark.blog.util.JWTUtil;
import com.clark.blog.util.ResponseBeanUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    @ApiOperation(value = "登录", notes = "登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String",paramType = "form"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String",paramType = "form")
    })
    @PostMapping("login")
    public ResponseBean login(@RequestParam("userName") String userName,
                              @RequestParam("password") String password) {
        log.info("User Login：" + userName);
        //通过用户名和加密的密码去查找用户
        String passwordEncrypt = Encrypt.passwordEncrypt(password);
        User user = userService.findUserByUserName(userName);
        //如果用户存在，则返回响应
        if (ObjectUtil.isNotNull(user) && passwordEncrypt.equals(user.getPassword())) {
            log.info("User Login Success：" + userName);
            Map<String, String> tokenMap = new HashMap<>(8);
            tokenMap.put("token", JWTUtil.sign(userName, passwordEncrypt));
            return ResponseBeanUtil.success("Login success", tokenMap);
        }
        //否则抛出异常
        throw new UnauthorizedException();
    }

    @ApiOperation(value = "注册", notes = "注册接口")
    @ApiImplicitParam(name = "user", value = "用户", required = true, dataType = "User")
    @PostMapping("register")
    public ResponseBean register(@RequestBody User user) {
        String password = Encrypt.passwordEncrypt(user.getPassword());
        user.setPassword(password);
        user.setCreateTime(new Date());
        User save = userService.insertUser(user);
        if (ObjectUtil.isNotNull(save)) {
            return ResponseBeanUtil.success("Register success");
        }
        return ResponseBeanUtil.error(HttpStatus.HTTP_INTERNAL_ERROR, "Register failed");
    }

    @ApiOperation(value = "测试全局异常", notes = "测试全局异常接口")
    @ApiImplicitParam(name = "ex", value = "异常名称",dataType = "String", paramType = "path")
    @GetMapping("test/exception/{ex}")
    public ResponseBean test(@PathVariable("ex") String ex) throws Exception {
        switch (ex) {
            case "Exception":
                throw new Exception("testException");
            case "ArithmeticException":
                throw new ArithmeticException("testArithmeticException");
            case "RuntimeException":
                throw new RuntimeException("testRuntimeException");
            default:
        }
        return ResponseBeanUtil.success("Test success");
    }
}
