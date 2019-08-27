package com.clark.blog.jobs;

import cn.hutool.core.date.DateTime;
import org.springframework.stereotype.Component;

/**
 * @Author: ClarkRao
 * @Date: 2019/8/27 22:46
 * @Description: 测试定时任务Job
 */
@Component
public class MyJob1 {
    /**
     * sayHello测试方法
     */
    public void sayHello() {
        System.out.println("MyJob1 >>> " + DateTime.now().toString("yyyy-MM-DD HH:mm:ss"));
    }
}
