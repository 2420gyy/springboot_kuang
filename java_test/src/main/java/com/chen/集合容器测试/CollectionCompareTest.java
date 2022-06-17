package com.chen.集合容器测试;

import java.util.*;

/**
 * @author chenchen
 * @date 2022-02-07 8:59
 * Comparable 是在集合内部定义的方法实现的排序，Comparator 是在集合外部实现的排序，
 * 所以，如想实现排序，就需要在集合外定义Comparator接口的方法或在集合内实现 Comparable接口的方法
 *
 */
public class CollectionCompareTest {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
// 添加对象到ArrayList中
        list.add(new Person("aaa", 510));
        list.add(new Person("bbb", 420));
        list.add(new Person("ccc", 330));
        list.add(new Person("ddd", 240));
        Collections.sort(list); //这里会自动调用Person中重写的compareTo方法。
        list.forEach(System.out::println);

        System.out.println("=======================");
        List<Person> people = Arrays.asList(
                new Person("Joe", 24),
                new Person("Pete", 18),
                new Person("Chris", 21)
        );
        Collections.sort(people, Comparator.comparingInt(Person::getAge));
        people.stream().forEach(System.out::println);

    }
}
class Person implements Comparable<Person>{

    private String name;

    private Integer age;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * x.compareTo(y) 来“比较x和y的大小”。
     * 若返回“负数”，意味着“x比y小”；
     * 返回“零”，意味着“x等于y”；
     * 返回“正数”，意味着“x大于y”。
     */
    @Override
    public int compareTo(Person person) {
        return age.compareTo(person.age);
        //return this.name - person.name;
    }
}

