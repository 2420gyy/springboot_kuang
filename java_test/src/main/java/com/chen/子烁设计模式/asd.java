package com.chen.子烁设计模式;

import java.lang.reflect.Field;

/**
 * @author chenchen
 * @date 2021-12-02 17:55
 */
public class asd {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Class cache = Integer.class.getDeclaredClasses()[0]; //1
        Field myCache = cache.getDeclaredField("cache"); //2
        myCache.setAccessible(true);//3

        Integer[] newCache = (Integer[]) myCache.get(cache); //4
        newCache[133] = newCache[132]; //5

        int a = 2;
        int b = a + a;
        System.out.printf("%d + %d = %d", a, a, b); //
    }
}
