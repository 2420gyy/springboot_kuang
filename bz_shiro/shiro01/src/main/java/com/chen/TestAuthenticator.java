package com.chen;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

/**
 * @author chenchen
 * @date 2021-12-23 12:36
 */
public class TestAuthenticator {
    public static void main(String[] args) {

        // 1.创建安全管理器对象
        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        // 2.给安全管理器设置realm
        securityManager.setRealm(new IniRealm("classpath:shiro.ini"));

        // 3. SecurityUtils 全局的工具类
        SecurityUtils.setSecurityManager(securityManager);

        // 4.关键对象 subject 主体
        Subject subject = SecurityUtils.getSubject();

        // 5.创建令牌 (身份信息和凭证信息组成了token)
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhangsan","123");

        try{
            System.out.println("认证前状态 "+subject.isAuthenticated());
            subject.login(usernamePasswordToken); // 用户认证
            System.out.println("认证后状态 "+subject.isAuthenticated());
        }catch (UnknownAccountException e){
            e.printStackTrace();
            System.out.println("认证失败：用户名错误");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("认证失败：密码错误");
        }

        Realm realm;

    }
}
