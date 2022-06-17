package com.chen.work有时间整理回顾下.流;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 根据list的某一个属性进行去重
 */
public class PredicateTest {
    public static void main(String[] args) {
        Person person1 = new Person(1,"zhangsan");
        Person person2 = new Person(2,"lisi");
        Person person3 = new Person(3,"wangwu");
        Person person4 = new Person(4,"wangwu");

        List<Person> personList = Arrays.asList(person1,person2,person3,person4);
        Map<String, List<Person>> collect1 = personList.stream().collect(Collectors.groupingBy(Person::getName));
        List<Person> personList1 = new ArrayList<>();
        collect1.forEach((k,v)->{
            personList1.add(v.get(0));
        });
        personList1.stream().forEach(System.out::println);

        System.out.println("=====================");

        List<Person> collect = personList.stream().filter(distinctByName(Person::getName)).collect(Collectors.toList());
        System.out.println(collect.size());
    }
    // 泛型!
    private static Predicate<? super Person> distinctByName(Function<? super Person,?> key) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>(3);
        return t->seen.putIfAbsent(key.apply(t),Boolean.TRUE) == null;
    }
    /*
    public static <T> Predicate<T> distinctById(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>(16);
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
     */


}
