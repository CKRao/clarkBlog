package com.clark.blog.entity;

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

    @Column(name = "user_name")
    private String userName;

    private String password;

    private String email;

    private boolean enable;

    @Column(name = "create_time")
    private Date createTime;

}
