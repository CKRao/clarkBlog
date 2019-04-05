package com.clark.blog.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Author: ClarkRao
 * @Date: 2019/4/5 21:02
 * @Description: 角色权限表
 */
@Entity
@Data
public class RolePermission {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    private Long id;

    @Column(name = "role_id")
    private Long roleId;


    @Column(name = "permission_id")
    private Long permissionId;
}
