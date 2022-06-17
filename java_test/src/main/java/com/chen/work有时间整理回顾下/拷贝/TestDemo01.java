package com.chen.work有时间整理回顾下.拷贝;

public class TestDemo01 {
    public static void main(String[] args) {
        int apples = 5;
        int pears = apples;
        System.out.println("pears:"+pears); // 5
        // 普通变量无法传递引用？
        apples = 6;

        System.out.println("apples:"+apples); // 6
        System.out.println("pears:"+pears); // 5

    }
}
