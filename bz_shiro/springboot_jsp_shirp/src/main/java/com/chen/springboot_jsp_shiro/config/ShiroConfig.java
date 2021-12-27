package com.chen.springboot_jsp_shiro.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @author chenchen
 * @date 2021-12-25 17:11
 */
@Configuration
public class ShiroConfig {

    // 1.shiroFilter
    // @Bean(name = "shiroFilterFactoryBean")
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 给filter设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        // 配置系统的受限资源
        /*
        anon 无需认证就可以访问
        authc 必须认证了才能访问
        user 必须有记住我功能
        perams 拥有某个资源的的权限才能访问
        roles 拥有某个角色权限才能访问
         */
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("/user/**","anon");
        hashMap.put("/register.jsp","anon");
        hashMap.put("/**","authc");
        // TODO 路径的问题(不理解)
        // 默认的认证界面路径
        bean.setLoginUrl("/login.jsp");

        bean.setFilterChainDefinitionMap(hashMap);
        return bean;
    }

    // 2.创建安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultSecurityManager(Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();

        // 给安全管理器设置realm
        defaultWebSecurityManager.setRealm(realm);

        return defaultWebSecurityManager;
    }


    // 3.创建realm TODO 返回Realm？？？
    @Bean
    public Realm getRealm(){
        MyRealm myRealm = new MyRealm();
        // 修改凭证校验匹配器
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // 设置加密算法
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        // 设置散列次数
        hashedCredentialsMatcher.setHashIterations(1024);
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return myRealm;
    }

}
