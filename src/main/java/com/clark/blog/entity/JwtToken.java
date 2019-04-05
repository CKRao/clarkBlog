package com.clark.blog.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Author: ClarkRao
 * @Date: 2019/4/5 23:27
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
public class JwtToken implements AuthenticationToken {
    private String token;

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
