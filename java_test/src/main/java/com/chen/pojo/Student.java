package com.chen.pojo;

import lombok.Data;

/**
 * @author chenchen
 * @date 2021-11-23 11:32
 */
@Data
public class Student {
    private int id;
    private String name;
    private Integer age;

    public Student() {
    }
    private Student(int id){

    }
    public Student(String name){}


    public Student(int id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    public void Run(){
        System.out.println(name+"在跑步");
    }
    private void Read(){
        System.out.println(name+"在一个人读书");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
