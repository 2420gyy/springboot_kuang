package com.chen.springboot_jsp_shiro.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author chenchen
 * @date 2021-12-26 13:59
 *
 * 获取springboot中创建好工厂的工具类
 *
 */
@Component
public class ApplicationContextUtils implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    // 根据bean的名字获取工厂中指定bean对象
    public static Object getBean(String beanName){
        return context.getBean(beanName);
    }
}
