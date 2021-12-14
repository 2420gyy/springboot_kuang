package com.chen.尚硅谷.枚举与注解;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
@Documented
public @interface CherryAnnotation {
    String name();
    int age() default 18;
    int[] score();
}
