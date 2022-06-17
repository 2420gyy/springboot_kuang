package com.chen.work有时间整理回顾下.流;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class stream01 {
    public static void main(String[] args) {
        List<String> oldP = new ArrayList<>();
        oldP.add("1");
        oldP.add("2");
        oldP.add("3");
        List<String> newP = new ArrayList<>();
        newP.add("1");
        newP.add("4");
        newP.add("5");

        /**
         * 需求：一起加进去，但不重复
         */
        // 1. 先把新加的中原本就包含的剔除
//        List<String> collect = newP.stream().filter(p1 -> !oldP.contains(p1)).collect(Collectors.toList());
//        System.out.println(collect);

        // 需要删除的id
        List<String> collect = oldP.stream().filter(old -> !newP.contains(old)).collect(Collectors.toList());
        // 添加的id
        List<String> collect1 = newP.stream().filter(newp -> !oldP.contains(newp)).collect(Collectors.toList());

        collect.forEach(System.out::println);
        System.out.println("==============");
        collect1.forEach(System.out::println);

        // 分割，在传参时最好转成List？？
        String[] str = {"123","345"};
        a(str);

    }
    public static void a(String... str){
        List<String> collect = Arrays.stream(str).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
    }


}
