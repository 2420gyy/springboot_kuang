package com.chen.springboot_jsp_shiro.config;

import com.chen.springboot_jsp_shiro.entity.BzUser;
import com.chen.springboot_jsp_shiro.service.IBzUserService;
import com.chen.springboot_jsp_shiro.utils.ApplicationContextUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * @author chenchen
 * @date 2021-12-25 17:12
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    private IBzUserService iBzUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String primaryPrincipal = (String) principals.getPrimaryPrincipal();
        System.out.println("============调用授权===========");
        // 根据主身份信息获取角色和权限信息
        if("zhangsan".equals(primaryPrincipal)){
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

            simpleAuthorizationInfo.addRole("admin");
            simpleAuthorizationInfo.addRole("user");

            // 操作权限:所有资源
            simpleAuthorizationInfo.addStringPermission("user:find:*");
            simpleAuthorizationInfo.addStringPermission("user:update:*");

            return simpleAuthorizationInfo;
        }


        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 在token中获取用户名
        String principal = (String)token.getPrincipal();
        // 在工厂中获取service对象 TODO 注入和这个工具类的问题
        IBzUserService bzUserServiceImpl = (IBzUserService)ApplicationContextUtils.getBean("bzUserServiceImpl");
        // bzUserServiceImpl.findBzUserByName()
        BzUser bzUserByName = iBzUserService.findBzUserByName(principal);

        // 根据身份信息使用数据库验证
        if(!ObjectUtils.isEmpty(bzUserByName)){
            // 1. 返回数据库中正确的用户名 2. 密码  3.提供当前realm的名字
            return new SimpleAuthenticationInfo(principal,bzUserByName.getPassword()
                    , ByteSource.Util.bytes(bzUserByName.getSalt()),this.getName());
        }
        return null;
    }
}
