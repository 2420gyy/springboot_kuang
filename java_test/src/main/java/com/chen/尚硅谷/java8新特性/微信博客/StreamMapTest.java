package com.chen.尚硅谷.java8新特性.微信博客;

import lombok.Data;

import java.util.ArrayList;

/**
 * @author chenchen
 * @date 2022-01-14 17:48
 */
@Data
public class StreamMapTest {
    /*
    map 就是把输入的一个参数，进行处理，然后输出（Function函数接口）
    不会改变数据源，流的思想

     */
    private String username;
    private String password;
    private Integer age;
    public StreamMapTest(){

    }

    public StreamMapTest(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public static void main(String[] args) {
        ArrayList<StreamMapTest> list = new ArrayList<>();

        list.add(new StreamMapTest("liubei","111",40));
        list.add(new StreamMapTest("zhangfei","222",30));
        list.add(new StreamMapTest("guanyu","333",35));

        System.out.println("list: "+list.toString());

        System.out.println("\ntest1:");
        // 接收一个参数并返回结果的函数
        list.stream().map(n->n)
                .forEach(n-> System.out.println(n));

        System.out.println("\ntest2--age:");
        list.stream().map(n->n.getAge())
                .forEach(n-> System.out.println(n));

        System.out.println("\ntest3--age:");
        list.stream().map(n->n.getAge()+1)
                .map(n->n).forEach(n-> System.out.println(n));

        System.out.println("\ntest2--username:");
        list.stream().map(n->n.getUsername())
                .forEach(n-> System.out.println(n));

        System.out.println("\ntest3--username:");
        //list.stream().map(n->n.getUsername()).map(n->n).forEach(n-> System.out.println(n));
        list.stream().map(n->n.getUsername())
                .forEach(n-> System.out.println(n));
    }
}
