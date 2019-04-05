package com.clark.blog.entity;

import com.clark.blog.entity.enumType.RoleType;
import lombok.Data;

import javax.persistence.*;

/**
 * @Author: ClarkRao
 * @Date: 2019/4/5 20:49
 * @Description: 角色表
 */
@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private RoleType role;

}
