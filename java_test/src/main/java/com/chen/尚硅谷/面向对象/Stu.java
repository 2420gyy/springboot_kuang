package com.chen.尚硅谷.面向对象;

import lombok.Data;

/**
 * @author chenchen
 * @date 2022-05-12 23:48
 */
@Data
public class Stu {
    private String name = "a";
    private int age;

    public Stu() {
        this.name ="无参构造器设置初始值";
    }
}
