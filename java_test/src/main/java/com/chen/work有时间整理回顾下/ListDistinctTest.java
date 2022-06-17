package com.chen.work有时间整理回顾下;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListDistinctTest {

    public static void main(String[] args) {
        Person person1 = new Person("张三",13);
        Person person2 = new Person("张三2",13);
        Person person3 = new Person("张三3",14);

        ArrayList<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

//        List<Person> collect = personList.stream().distinct().collect(Collectors.toList());
        Map<Integer, Person> collect = personList.stream().collect(Collectors.toMap(Person::getAge, Function.identity(), (key1, key2) -> key1));
        // 遍历list
        Iterator<Person> iterator = personList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        // 遍历map
        int size = collect.size();
        for (int i = 0; i < size; i++) {
            System.out.println(collect.keySet()+"::"+collect.values());
        }
        // 遍历map!!!
        collect.keySet().stream().forEach(key->{
            System.out.println(key+"::"+collect.get(key));
        });


        List<Person> collect1 = collect.values().stream().collect(Collectors.toList());
        System.out.println(collect1);

//        System.out.println(personList);




    }

}
