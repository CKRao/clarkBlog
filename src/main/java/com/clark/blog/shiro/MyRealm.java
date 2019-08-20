package com.clark.blog.shiro;

import com.clark.blog.entity.JwtToken;
import com.clark.blog.entity.Permission;
import com.clark.blog.entity.Role;
import com.clark.blog.entity.User;
import com.clark.blog.service.UserService;
import com.clark.blog.util.JWTUtil;
import com.clark.blog.util.ValidateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: ClarkRao
 * @Date: 2019/4/5 23:35
 * @Description:
 */
@Slf4j
@Component
public class MyRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    /**
     * 必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String token = principals.getPrimaryPrincipal().toString();
        log.info("进入Realm的权限验证:" + token);
        String username = JWTUtil.getUserName(principals.toString());
        log.info("Realm获取到的username:" + username);
        User user = userService.findUserByUserName(username);
        //查找用户角色列表
        List<Role> roles = userService.selectRoleByUser(user);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Role role : roles) {
            simpleAuthorizationInfo.addRole(role.getRole().toString());
            //查找权限列表
            List<Permission> permissions = userService.selectPermissionByRole(role);
            for (Permission permission : permissions) {
                simpleAuthorizationInfo.addStringPermission(permission.getPermission().toString());
            }
        }
        return simpleAuthorizationInfo;

    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String userName = JWTUtil.getUserName(token);
        if (ValidateUtil.isEmpty(userName)) {
            throw new AuthenticationException("token无效");
        }

        User user = userService.findUserByUserName(userName);
        if (ValidateUtil.isEmpty(user)) {
            throw new AuthenticationException("用户不存在!");
        }
        if (!JWTUtil.verify(token, userName, user.getPassword())) {
            throw new AuthenticationException("用户名或密码错误");
        }
        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
