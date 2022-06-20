package com.chen.work有时间整理回顾下.EffectiveJava.Singleton;

public class SingletonDemo_hungry {
    private static SingletonDemo_hungry instance=new SingletonDemo_hungry();
    private SingletonDemo_hungry(){

    }
    public static SingletonDemo_hungry getInstance(){
        return instance;
    }
}