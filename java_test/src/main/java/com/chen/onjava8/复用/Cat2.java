package com.chen.onjava8.复用;

/**
 * @author chenchen
 * @date 2022-04-24 16:15
 */
public class Cat2 extends Animal1{

    public void myMethod(){
        System.out.println("cat2自己的方法");
    }

    @Override
    public void eat() {
        System.out.println("cat2重写");
    }
}
