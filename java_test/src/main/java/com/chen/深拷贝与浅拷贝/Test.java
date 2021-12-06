package com.chen.深拷贝与浅拷贝;

import com.google.common.collect.ImmutableList;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenchen
 * @date 2021-12-03 11:08
 */
public class Test {

    // faker unmodifiable
    // 反射
    public static void main(String[] args) throws Exception{
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        System.out.println(list);

        List unmodifiableList = Collections.unmodifiableList(list);
        ImmutableList immutableList = ImmutableList.copyOf(list);

        list.add(2);
        System.out.println(unmodifiableList);
        System.out.println(immutableList);

        System.out.println("==========================");

        String s = "Hello World";
        System.out.println("s = " + s);

        Field valueFieldOfString = String.class.getDeclaredField("value");
        valueFieldOfString.setAccessible(true);

        char[] value = (char[]) valueFieldOfString.get(s);
        value[5] = '_';
        System.out.println("s = " + s);

    }
}
