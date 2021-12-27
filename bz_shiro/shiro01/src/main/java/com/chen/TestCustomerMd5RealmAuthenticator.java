package com.chen;

/**
 * @author chenchen
 * @date 2021-12-23 15:12
 */

import com.chen.realm.CustomerMd5Realm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;

/**
 * 认证
 *
  */
public class TestCustomerMd5RealmAuthenticator {
    public static void main(String[] args) {

        /**
         * 1. DefaultSecurityManager 需要设置realm
         * ----------------------------
         *  在realm中 从token中得到getPrincipal
         *  从数据库中通过用户名拿到密码（加密过的）和盐
         *  返回 new SimpleAuthenticationInfo()
         * ----------------------------
         * 2. realm 需要设置 HashedCredentialsMatcher
         *
         * 3. HashedCredentialsMatcher 设置算法和散列次数
         *
         * ===========================================
         *
         * // 为工具类设置安全管理器
         * SecurityUtils.setSecurityManager(defaultSecurityManager);
         *
         * // 使用工具类得到subject
         * Subject subject = SecurityUtils.getSubject();
         * // 使用token登录
         * subject.login(usernamePasswordToken);
         * // token
         * UsernamePasswordToken usernamePasswordToken =  new UsernamePasswordToken(表单输入的用户名和密码)
         */



        //
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        // 设置自定义realm
        CustomerMd5Realm realm = new CustomerMd5Realm();
        // 设置realm使用hash凭证匹配器
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        // 使用算法
        credentialsMatcher.setHashAlgorithmName("md5");
        // 散列次数
        credentialsMatcher.setHashIterations(1024);
        realm.setCredentialsMatcher(credentialsMatcher);
        defaultSecurityManager.setRealm(realm);
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


        //认证的用户进行授权
        if(subject.isAuthenticated()){
            // 1.基于角色的权限控制
            System.out.println("------"+subject.hasRole("admin"));
            // 2.基于多角色权限控制 (必须同时有)
            System.out.println("------"+subject.hasAllRoles(Arrays.asList("admin", "user")));
            // 3.是否具有其中一个角色
            boolean[] booleans = subject.hasRoles(Arrays.asList("admin", "user1"));
            for (boolean aBoolean : booleans) {
                System.out.println("是否有角色 "+aBoolean);
            }

            // 基于权限字符串的访问控制 资源标识符:操作:资源类型
            // 最后的一个如果是* 可以省略
            System.out.println("访问控制 "+subject.isPermitted("user:*:*"));
            System.out.println("权限 "+subject.isPermitted("product:create"));

            // 分别具有哪些权限
            System.out.println("权限(重载)");
            for (boolean b : subject.isPermitted("user:1:1", "user:2:2", "user:*:3")) {
                System.out.println(b);
            }
            // 同时具有哪些权限
            boolean permittedAll = subject.isPermittedAll("user:1:1", "product:2");
            System.out.println(permittedAll);
        }

    }
}
