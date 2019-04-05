package com.clark.blog.entity;

import com.clark.blog.entity.enumType.RoleType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

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
    @GeneratedValue(strategy=GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    private Long id;

    private RoleType role;

}
