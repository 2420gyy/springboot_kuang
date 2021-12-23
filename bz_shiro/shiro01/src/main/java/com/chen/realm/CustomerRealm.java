package com.chen.realm;

/**
 * @author chenchen
 * @date 2021-12-23 15:06
 */

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 将认证/授权Authorizing的数据来源转为数据库的实现
 */
public class CustomerRealm extends AuthorizingRealm {
    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
    // 认证 父类中的方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 在token中获取用户名
        String principal = (String)token.getPrincipal();
        // 根据身份信息使用数据库验证
        if(principal.equals("zhangsan")){
            // 1. 返回数据库中正确的用户名 2. 密码  3.提供当前realm的名字
            return new SimpleAuthenticationInfo(principal,"123",this.getName());
        }
        System.out.println(principal);
        return null;
    }
}
