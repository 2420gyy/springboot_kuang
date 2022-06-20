package com.chen.work有时间整理回顾下.EffectiveJava.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MainClass {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        Runtime runtime = new Runtime();
        // 单例模式
        Runtime runtime1 = Runtime.getRuntime();

        // 通过反射创建对象
        Class<Runtime> runtimeClass = Runtime.class;

        Runtime runtime2 = runtimeClass.newInstance();

        Constructor<Runtime> declaredConstructor = runtimeClass.getDeclaredConstructor();
        Runtime runtime3 = declaredConstructor.newInstance();


    }
}
