package com.clark.blog.jobs;

import com.clark.blog.service.HelloService;
import lombok.Data;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @Author: ClarkRao
 * @Date: 2019/8/27 22:49
 * @Description: MyJob2 测试定时任务
 */
@Data
public class MyJob2 extends QuartzJobBean {
    HelloService helloService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        helloService.sayHello();
    }
}
