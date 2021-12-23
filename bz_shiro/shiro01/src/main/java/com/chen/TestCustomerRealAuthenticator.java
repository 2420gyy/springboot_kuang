package com.chen;

/**
 * @author chenchen
 * @date 2021-12-23 15:12
 */

import com.chen.realm.CustomerRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * 认证
 *
  */
public class TestCustomerRealAuthenticator {
    public static void main(String[] args) {
        //
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        // 设置自定义realm
        defaultSecurityManager.setRealm(new CustomerRealm());
        //
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        //
        Subject subject = SecurityUtils.getSubject();
        // 创建token
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhangsan","123");
        try{
            subject.login(usernamePasswordToken);
            System.out.println(subject.isAuthenticated());
        }catch (UnknownAccountException e){
            System.out.println("用户不存在");
            e.printStackTrace();
        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
            e.printStackTrace();
        }

    }
}
