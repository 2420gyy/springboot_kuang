package com.chen.compareToTest;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author chenchen
 * @date 2021-12-01 14:22
 */

/**
 * 对于hashCode()和equals()方法，比较个体属性的顺序不影响返回的值，但是，在compareTo()中，通过你比较对象的顺序来定义对象的顺序。
 * 在结论中我只想强调Comparable接口是多么的重要。它既用于java.util.Arrays，
 * 也用于java.util.Collections实用程序类，来排序元素和搜索排序集合中的元素。使用TreeSet和Tree Map，
 * 就更简单了——想要它们会自动排序必须实现Comparable接口的元素。
 */
@Data
@AllArgsConstructor
class Apple implements Comparable<Apple>{
    private String variety;
    private String color;
    private int weight;

    @Override
    public int compareTo(Apple other) {
        // if(this.weight > other.weight){
        //     return 1;
        // }else if(this.weight < other.weight){
        //     return -1;
        // }
        // return 0;
        int result = this.variety.compareTo(other.variety);
        if(result == 0){
            result = this.color.compareTo(other.color);
        }
        if(result == 0){
            result = Integer.compare(this.weight,other.weight);
        }
        return result;
    }
}

public class AppleTest{
    public static void main(String[] args) {

        Apple apple1 = new Apple("品种a","red",2);
        Apple apple2 = new Apple("品种a","yello",1);
        int res = apple1.compareTo(apple2);
        System.out.println(res);
    }
}
