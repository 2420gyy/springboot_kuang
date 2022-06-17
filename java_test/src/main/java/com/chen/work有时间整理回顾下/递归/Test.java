package com.chen.work有时间整理回顾下.递归;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        /*自身调用：原问题可以分解为子问题，子问题和原问题的求解方法是一致的，即都是调用自身的同一个函数。
          终止条件：递归必须有一个终止的条件，即不能无限循环地调用本身。
         */
        // eg:例子1
//        System.out.println(sum(5));

        /*原问题和子问题都可以用同一个函数关系表示*/
        // eg: 阶乘问题 1*2*3*4*5*6 ？
//        System.out.println(factorial(4));

        List<CatalogVO> lists = new ArrayList<>();
        lists.addAll(Arrays
                .asList(new CatalogVO("1","0"),
                        new CatalogVO("2","1"),
                        new CatalogVO("3","1"),
                        new CatalogVO("4","2"),
                        new CatalogVO("5","2"),
                        new CatalogVO("6","3")
                        ));

        lists.stream().forEach(System.out::println);

        List<CatalogVO> tree = createTree(lists, "0");
        System.out.println("===========");
        tree.stream().forEach(System.out::println);

    }

    public static List<CatalogVO> createTree(List<CatalogVO> lists, String pid) {
        List<CatalogVO> tree = new ArrayList<>();
        for (CatalogVO catelog : lists) {
            if (catelog.getParentId().equals(pid)) {
                catelog.setChirldren(createTree(lists,catelog.getId()));
                tree.add(catelog);
            }
        }
        return tree;
    }



    private static int factorial(int n) {
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }


    public static int sum(int n) {
        if (n <= 1) {
            return 1;
        }
        return sum(n - 1) + n;
    }

}
