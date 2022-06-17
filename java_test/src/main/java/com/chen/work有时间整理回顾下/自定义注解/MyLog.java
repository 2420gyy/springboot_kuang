package com.chen.work有时间整理回顾下.自定义注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/** 
 * @description: 自定义日志注解
 * @author chenchen
 * @date: 2022/5/9 11:50
 */ 
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyLog {
    String value() default "";
}
