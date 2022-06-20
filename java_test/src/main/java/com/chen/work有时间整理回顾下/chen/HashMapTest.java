package com.chen.work有时间整理回顾下.chen;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest{
    public static void main(String[] args) {
        Map<Object,Object> map = new HashMap<>();
        map.put("a","1");
        map.put(null,"2");
        map.put(null,"3");// 将前面的值覆盖了
        map.put("b",null);
        map.forEach((k,v)->{
            System.out.println(k+" "+v);
        });
        System.out.println("======");
        System.out.println(map.get("b"));
        System.out.println(map.get("c"));// 不能用get返回null的结果判断该值是否存在
        System.out.println(map.containsKey("b"));
        double v = 'a' + 2.1;
        int i=0;
        Integer j = new Integer(0);
        System.out.println(i==j);
        System.out.println(j.equals(i));
        int value = 2;
        System.out.print(value);
        System.out.print(value++);
        System.out.print(value);
        throw new RuntimeException();
        
    }
}
