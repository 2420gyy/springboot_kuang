package com.chen.尚硅谷.java8新特性.博客;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

interface AppleFormatter {
    String format(Apple apple);
}

/**
 * 行为参数化，就是一个方法接受多个不同的行为作为参数，并在内部使用它们，完成不同行为的能力。
 * 传递代码，就是将行为作为参数传递给方法。
 */
public class AppleOutput{
     static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter){
        for (Apple apple : inventory) {
            String format = formatter.format(apple);
            System.out.println(format);
        }
    }
    
     public static void main(String[] args){
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple("red", 100));
        inventory.add(new Apple("red", 200));
        inventory.add(new Apple("green", 200));

        prettyPrintApple(inventory, new AppleFormatter() {
            @Override
            public String format(Apple apple) {
                String characteristic = apple.getWeight()>150?"heavy":"light";
                return "A " + characteristic + " " + apple.getColor() + " apple.";
            }
        });
        // 匿名内部类 -> lambda
         prettyPrintApple(inventory, apple -> {
             String characteristic = apple.getWeight()>150?"heavy":"light";
             return "A " + characteristic + " " + apple.getColor() + " apple.";
         });

        prettyPrintApple(inventory, apple -> "An apple of " + apple.getWeight() + "g");

    }

    @Test
    public void sort(){
        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple("red", 100));
        appleList.add(new Apple("red", 160));
        appleList.add(new Apple("green", 60));

        // appleList.sort((o1, o2) -> o1.getWeight()-o2.getWeight());
        appleList.sort(Comparator.comparingInt(Apple::getWeight));
        Iterator<Apple> iterator = appleList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testRunnable(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("running");
            }
        };

        Runnable runnable1 = ()-> System.out.println("run");
        new Thread(runnable).start();
    }
    @Test
    public void testIntPredicate() {
        //无装箱
        IntPredicate intPredicate = (int t) -> t%2 == 0;
        boolean isEven = intPredicate.test(100);
        assertTrue(isEven);
        //装箱
        Predicate<Integer> integerPredicate = (Integer i) -> i%2 == 0;
        boolean isEven2 = integerPredicate.test(100);
        assertTrue(isEven2);
    }

    @Test
    public void sort1(){
        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple("red", 100));
        appleList.add(new Apple("red", 160));
        appleList.add(new Apple("green", 60));
        // 有一个自动装箱的问题
        /**
         * 为了避免装箱操作，对Predicate和Function<T,R>等通用函数式接口的原始类特殊化：IntPredicate,InToLong等。
         * //无装箱
         *     IntPredicate intPredicate = (int t) -> t%2 == 0;
         * //装箱
         *     Predicate<Integer> integerPredicate = (Integer i) -> i%2 == 0;
         */
        // appleList.sort(Comparator.comparing(Apple::getWeight));
        appleList.sort(Comparator.comparingInt(Apple::getWeight));
        // 降序
        appleList.sort(Comparator.comparingInt(Apple::getWeight).reversed());

        // 复合lambda
        appleList.sort(Comparator.comparing(Apple::getColor)
                .reversed()
                .thenComparingInt(Apple::getWeight));
        Predicate<Apple> red = apple -> "red".equalsIgnoreCase(apple.getColor());
        // https://www.cnblogs.com/woshimrf/p/java8-lambda.html
        // Predicate<Apple> nonRed = red.negate();
        // Predicate<Apple> redAndHeavy = red.and(apple -> apple.getWeight() > 150);

        Function<Integer, Integer> f = x -> x +1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        int r = h.apply(2);
        assertEquals(6, r);

        Supplier<Apple> appleCopier = Apple::new;
        appleCopier.get();

    }
    private int f(int x){
        return (x + 1) * 2;
    }

}