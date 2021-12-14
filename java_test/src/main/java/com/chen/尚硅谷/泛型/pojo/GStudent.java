package com.chen.尚硅谷.泛型.pojo;

/**
 * @author chenchen
 * @date 2021-12-07 14:18
 */
public class GStudent extends GPerson{
    // 最核心的一点就是父类不能赋值给子类，子类可以赋值给父类，赋值对象
    int i = super.a;

    @Override
    public void GP() {
        // super.GP();
        System.out.println("子类继承父类的方法");
    }

    public void GS(){
        System.out.println("GStudent的方法");
    }
}
