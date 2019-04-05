package com.clark.blog.entity;

import lombok.Data;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name")
    private String UserName;

    private String password;

    private String email;

    private boolean enable;

    @Column(name = "create_time")
    private Date createTime;

}
