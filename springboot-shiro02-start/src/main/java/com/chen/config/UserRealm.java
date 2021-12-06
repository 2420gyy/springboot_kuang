package com.chen.config;

import com.chen.pojo.User;
import com.chen.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;

/**
 * 自定义的UserRealm
 * @author chenchen
 * @date 2021-11-08 19:02
 */
public class UserRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    /**
     * @Author chenchen
     * @Description  用户授权
     * @Date 19:02 2021-11-08
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权===doGetAuthorizationInfo");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 给用户授权
        // info.addStringPermission("user:add");
        // 拿到当前用户登陆对象
        Subject subject= SecurityUtils.getSubject();
        // 拿到User对象
        User currentUser= (User) subject.getPrincipal();
        // 设置当前用户对象
        info.addStringPermission(currentUser.getPerms());
        return info;
    }
    /**
     * @Author chenchen
     * @Description  用户认证
     * @Date 19:02 2021-11-08
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了认证===doGetAuthenticationInfo");
        /*
        UsernamePasswordToken是AuthenticationToken的子类(实现类)
        * */
        /* 用户名，密码，数据库中获取 */
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        /* 认证: 即拿数据库里面的用户和用户名比较 -- 获取用户名 */
        User user=userService.queryUserByName(userToken.getUsername());
        String name=user.getName();
        String password=user.getPwd();
        if(user==null){
            /* 说明查无此人 */
            return null;
        }
        /* 密码认证,shiro做 放入User对象 */
        return new SimpleAuthenticationInfo(user,password,"");
    }
}
