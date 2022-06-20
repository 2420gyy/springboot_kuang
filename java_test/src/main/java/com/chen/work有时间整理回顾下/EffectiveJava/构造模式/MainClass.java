package com.chen.work有时间整理回顾下.EffectiveJava.构造模式;

public class MainClass {

    public static void main(String[] args) {
        UserBuilder userBuilder = new UserBuilder(2);
        User user = userBuilder.name("张三").BMI("xxx").health("健康").build();
        System.out.println(user);
    }

}