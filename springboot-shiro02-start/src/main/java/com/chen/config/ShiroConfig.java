package com.chen.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author chenchen
 * @date 2021-11-08 18:59
 */
@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean:3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("MyDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器
        /*
        anon 无需认证就可以认证
        authc 必须认证了才能访问
        user 必须有记住我功能
        perams 拥有某个资源的的权限才能访问
        roles 拥有某个角色权限才能访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();
        // 可以配置的方式
        // TODO Map<String, Filter> filtersMap = new LinkedHashMap<String, Filter>();
        // filtersMap.put("authc", loginFilter); // 默认拦截器
        //授权 哪个url能被谁访问
        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/update","perms[user:update]");
        bean.setFilterChainDefinitionMap(filterMap);

        //设置登录的请求
        bean.setLoginUrl("/toLogin");
        //设置未授权的请求
        bean.setUnauthorizedUrl("/noauth");

        bean.setFilterChainDefinitionMap(filterMap);

        return bean;
    }

    /**
     * 重写DefaultWebSessionManager，
     * 从request header中获取session id
     * 用户认证、权限校验是根据sessionId判断用户身份
     * extends DefaultWebSessionManager
     */


    //DefaultWebSecurityManager:2
    @Bean(name = "MyDefaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建realm对象 ， 需要自定义的类:1
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
    //整合shiroDialect:用来整合shiro thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

}
