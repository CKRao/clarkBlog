package com.clark.blog.service;

import cn.hutool.core.date.DateTime;

/**
 * @Author: ClarkRao
 * @Date: 2019/8/27 23:14
 * @Description:
 */
public class HelloService {
    public void sayHello() {
        System.out.println("hello service >>>"+ DateTime.now().toString("yyyy-MM-DD HH:mm:ss"));
    }
}
