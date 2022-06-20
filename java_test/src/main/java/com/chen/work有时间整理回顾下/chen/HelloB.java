package com.chen.work有时间整理回顾下.chen;

public class HelloB extends HelloA {
    public HelloB() {
        System.out.println("b的构造方法");
    }

    @Override
    public void out(){
        System.out.println("b的out方法");
    }

    {
        System.out.println("I’m B class");
    }

    static {
        System.out.println("static B");
    }

    public static void main(String[] args) {
        new HelloB();
    }
}

class HelloA {
    public HelloA() {
        System.out.println("a的构造方法");
    }

    public void out(){
        System.out.println("a的out方法");
    }

    {
        // Java会把构造代码块放到每种构造方法的前面
        System.out.println("I’m A class");
    }

    static {
        System.out.println("static A");
    }
}