package com.chen.work有时间整理回顾下;

import lombok.Data;

@Data
public class Person {

    private String name;

    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
