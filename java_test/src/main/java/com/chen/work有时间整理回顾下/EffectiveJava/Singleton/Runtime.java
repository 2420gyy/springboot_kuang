package com.chen.work有时间整理回顾下.EffectiveJava.Singleton;

public class Runtime {

    /**
     * 引用变量被final修饰之后，虽然不能再指向其他对象，但是它指向的对象的内容是可变的。
     * static作用于成员变量用来表示只保存一份副本，而final的作用是用来保证变量不可变
     */

    // 饿汉式？？？
    private static Runtime currentRuntime = new Runtime();

    public static Runtime getRuntime() {
        return currentRuntime;
    }

    // 防御通过反射创建对象？？？
    public Runtime() {
        if(currentRuntime != null){
            throw  new RuntimeException(">>>");
        }
    }
}