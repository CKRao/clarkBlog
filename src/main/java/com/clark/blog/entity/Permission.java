package com.clark.blog.entity;

import com.clark.blog.entity.enumType.PermissionType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author: ClarkRao
 * @Date: 2019/4/5 21:00
 * @Description: 权限表
 */
@Entity
@Data
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private PermissionType permission;
}
