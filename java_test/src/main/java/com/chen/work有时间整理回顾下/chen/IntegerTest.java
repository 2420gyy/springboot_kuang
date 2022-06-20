package com.chen.work有时间整理回顾下.chen;


/**
 * 引用类型的==是比较对应的引用地址
 * Integer中使用的默认缓存是-128到127
 * Integer b=Integer.valueOf(8);和Integer b=8;是一样的效果
 * Integer.valueOf()方式，比较是否在缓存范围之内，在就直接从缓存中获取，不在new一个Integer对象
 */

public class IntegerTest {
    public static void main(String[] args) {
        Integer num1 = new Integer(10);
        Integer num2 = new Integer(10);

        System.out.println(num1.equals(num2)); // t
        System.out.println(num1 == num2); // t -> f new呀！！！

        System.out.println("==============");

        Integer num3 = 100;
        Integer num4 = 100;
        System.out.println(num3.equals(num4)); // t
        System.out.println(num3 == num4); // t

        System.out.println("==============");

        Integer num5 = 1000;
        Integer num6 = 1000;
        System.out.println(num5.equals(num6)); // t
        System.out.println(num5 == num6); // f

    }
}
