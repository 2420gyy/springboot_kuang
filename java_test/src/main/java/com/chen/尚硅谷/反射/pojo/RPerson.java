package com.chen.尚硅谷.反射.pojo;

/**
 * @author chenchen
 * @date 2021-12-12 0:46
 */
public class RPerson {
    private String name;
    public int age;

    public RPerson() {
    }

    public RPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private RPerson(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("show方法-public");
    }
    private String showNation(String nation){
        System.out.println("我的国籍是：" + nation+"private");
        return nation;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "RPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
