package com.clark.blog.entity;

import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: ClarkRao
 * @Date: 2019/4/5 20:46
 * @Description: 用户表
 */
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    private Long id;

    @ApiParam(name = "userName",value = "用户名",required = true)
    @Column(name = "user_name")
    private String userName;

    @ApiParam(name = "password",value = "密码",required = true)
    private String password;

    @ApiParam(name = "email",value = "邮箱")
    private String email;

    @ApiParam(name = "enable",value = "是否有效",required = true)
    private boolean enable;

    @ApiParam(name = "createTime",value = "创建时间",required = true)
    @Column(name = "create_time")
    private Date createTime;

}
