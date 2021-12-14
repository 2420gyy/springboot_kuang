package com.chen.尚硅谷.java8新特性.博客;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author chenchen
 * @date 2021-12-13 11:05
 */

/**
 * 1.调用接口的实现方法
 * 2.实现匿名内部类；（idea有提示）
 * 3.替换为lambda
 */

public class testPredicate{
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple("red", 100));
        inventory.add(new Apple("red", 200));
        inventory.add(new Apple("green", 200));
        List<Apple> redHeavyApples = filterApples(inventory, new AppleRedAndHeavyPredicate());
        assertEquals(1, redHeavyApples.size());
        assertEquals(200, redHeavyApples.get(0).getWeight());

        System.out.println("java8提供了把方法当做参数传递的能力");
        List<Apple> apples = filterApples(inventory, apple -> "red".equals(apple.getColor()) && apple.getWeight() > 150);
        assertEquals(1, apples.size());
        assertEquals(200, apples.get(0).getWeight());
        // 当条件发生改变的时候只要增加一个类就可以。但java8提供了更好的选择，
        // 一种你只要声明一个接口，具体实现不用管，只有当使用的时候才去关心
        // 接口，实现类
        filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor()) && apple.getWeight() > 150;
            }
        });
        // 除了接口声明，不需要实现接口的类。我们只需要传入一个类似匿名内部类的东西，是的，lambda表达式和匿名内部类是可以互相转换的。
        // 我们设计接口的时候只要声明一个接口作为参数，然后再调用的时候把逻辑当做参数传进去。
        // 这个在我看来就是传递方法了。就像Javascript，可以把一个方法当做参数。


        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple("red", 100));
        appleList.add(new Apple("red", 160));
        appleList.add(new Apple("green", 60));

        // 通用的
        List<Apple> appleList1 = filter(appleList, (Apple apple) -> apple.getColor().equals("red") && apple.getWeight() < 160);
        for(Apple apple:appleList1){
            System.out.println(apple);
        }

        List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> lessThan4Numbers = filter(numberList, (Integer num) -> num < 4);
        assertEquals(3, lessThan4Numbers.size());

    }



    static List<Apple> filterApples(List<Apple> inventory,ApplePredicate applePredicate){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if(applePredicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
}

    // 普遍的一个过滤方法
    static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<T>();
        for (T e : list) {
            if (p.test(e)){
                result.add(e);
            }
        }

        return result;
    }


}


class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}

class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}

class AppleRedAndHeavyPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor()) && apple.getWeight() >150;
    }
}
