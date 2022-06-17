package com.chen.work有时间整理回顾下.流;

import java.util.ArrayList;
import java.util.List;

public class 匹配01 {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        person1.setId(1);
        person1.setName("小明");
        person2.setId(2);
        person2.setName("小李");
        person3.setId(3);
        person3.setName("小张");
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
//        System.out.println(personList);
        // anyMatch 任一个包含即为true
        boolean isC = personList.stream().anyMatch(person -> person.getName().contains("明"));
        if(isC){
            System.out.printf("anyMatch包含");
        }
        System.out.println();
        // allMatch 全部都包含为true
        boolean isA = personList.stream().allMatch(person -> person.getName().contains("小"));
        if(isA){
            System.out.printf("allMatch包含");
        }
        System.out.println();
        // noneMatch 没有一个包含为true，即都不含有
        boolean isN = personList.stream().noneMatch(person -> person.getName().contains("夏"));
        if(isN){
            System.out.printf("noneMatch包含");
        }
    }
}
