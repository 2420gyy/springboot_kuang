package com.chen.onjava8.复用;

public class Main {

    public static void main(String[] args) {

        Animal1 animal = new Cat(); //向上转型
        // Animal1决定了可以调用哪些方法
        // Cat决定了调用谁的方法
        // 类接口只可能失去方法，不会增加方法

        Cat cat = new Cat();
        cat.peat();


        // 上转型对象可以操作和使用子类继承或者重写的方法。
        Animal1 animal1 = new Cat2();
        animal1.eat1();
        animal1.eat();


        Cat2 cat2 = new Cat2();
        cat2.eat();
        cat2.myMethod();

        //一般实际工作中person都会是一个接口，而接口对不能new象，就无法调用方法，
        // 这时候就要向上转型，再调用方法，而且只能调用接口里的方法，而不能调用实现类方法。nb

        persont persont = new Cat();
        persont.peat();



    }

}