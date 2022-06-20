package com.chen.work有时间整理回顾下.EffectiveJava.Singleton;

public class SingletonDemo_lazy {
    private static SingletonDemo_lazy instance;
    private SingletonDemo_lazy(){

    }
    public static SingletonDemo_lazy getInstance(){
        if(instance==null){
            instance=new SingletonDemo_lazy();
        }
        return instance;
    }
}
