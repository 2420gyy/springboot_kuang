package com.chen.尚硅谷.枚举与注解;

import java.lang.annotation.*;

/**
 * @author chenchen
 * @date 2021-12-08 17:11
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface MyAnnotations {

    MyAnnotation[] value();
}
