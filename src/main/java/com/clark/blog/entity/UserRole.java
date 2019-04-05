package com.clark.blog.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: ClarkRao
 * @Date: 2019/4/5 20:53
 * @Description: 用户角色表
 */
@Entity
@Data
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;
}
