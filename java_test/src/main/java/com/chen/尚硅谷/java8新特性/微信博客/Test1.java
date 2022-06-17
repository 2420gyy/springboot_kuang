package com.chen.尚硅谷.java8新特性.微信博客;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author chenchen
 * @date 2022-01-12 15:44
 */
public class Test1 {
    @Test
    public void test1(){
        List<Integer> salary = new ArrayList<>();
        salary.add(14000);
        salary.add(5000);
        salary.add(12000);
        salary.add(15000);
        // 从员工集合中筛选出salary大于8000的员工，并放置到新的集合里
        List<Integer> collect = salary.stream().filter(s -> s > 8000).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
        System.out.println("======");
        List<Integer> collect1 = salary.stream().sorted().collect(Collectors.toList());
        collect1.stream().forEach(System.out::println);
    }
    @Test
    public void test2(){
        // 了解流的一些特性
        // 对流的中间操作和终端操作

        List<String> list = Arrays.asList("a", "b", "c");
        // 创建一个顺序流
        Stream<String> stream1 = list.stream();
        // 创建一个并行流
        Stream<String> parallelStream = list.parallelStream();

        // 使用java.util.Arrays.stream(T[] array)方法用数组创建流
        int[] array={1,3,5,6,8};
        IntStream stream2 = Arrays.stream(array);

        // Stream的静态方法 of() iterator() generate()
        Stream<String> stream3 = Stream.of("a", "b", "c");// 同 Arrays.stream(values);
        List<String> values = Arrays.asList("a", "b", "c");
        String[] strs = {"a", "b", "c"};
        /**
         * ? extends Object[] array
         * ...
         */
        Arrays.stream(strs);

        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2).limit(5);
        iterate.forEach(System.out::println);
        System.out.println("======");
        // Supplier<T>接口被称之为生产型接口，指定接口的泛型是什么类型，那么接口中的get方法就会生产什么类型的数据
        Stream<Double> limit = Stream.generate(() -> Math.random()).limit(3);
        limit.forEach(System.out::println);

        System.out.println("======");
    }

    @Test
    public void test4(){
        ArrayList<String> list = new ArrayList<>();
        list.stream().forEach(System.out::println);
        System.out.println("======");
    }
}
