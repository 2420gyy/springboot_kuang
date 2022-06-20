package com.chen.work有时间整理回顾下.EffectiveJava.Singleton;

public class SingletonDemo {
    /**
    静态内部类不会在单例加载时就加载，而是在调用getInstance()方法时才进行加载，
    达到了类似懒汉模式的效果，而这种方法又是线程安全的。
     */
    private static class SingletonHolder{
        private static SingletonDemo instance=new SingletonDemo();
    }
    private SingletonDemo(){
        System.out.println("Singleton has loaded");
    }
    public static SingletonDemo getInstance(){
        return SingletonHolder.instance;
    }
}