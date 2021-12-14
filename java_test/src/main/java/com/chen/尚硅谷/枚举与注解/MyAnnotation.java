package com.chen.尚硅谷.枚举与注解;

import java.lang.annotation.*;

/**
 * @author chenchen
 * @date 2021-12-08 10:11
 */
@Inherited
@Repeatable(MyAnnotations.class) // 保证生命周期一致
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value() default "hello";
}
