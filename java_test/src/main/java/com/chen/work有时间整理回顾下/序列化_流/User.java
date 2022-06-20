package com.chen.work有时间整理回顾下.序列化_流;

import lombok.Data;

import java.io.Serializable;

/**
 * java 实现序列化很简单，只需要实现Serializable 接口即可。
 */
@Data
public class User implements Serializable {

    //年龄
    private int age;
    //名字
    private String name ;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
