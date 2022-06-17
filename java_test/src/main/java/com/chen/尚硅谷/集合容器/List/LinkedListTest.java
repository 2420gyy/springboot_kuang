package com.chen.尚硅谷.集合容器.List;

import org.junit.Test;

import java.util.LinkedList;

public class LinkedListTest {
    @Test
    public void test1(){
        LinkedList<String> sites = new LinkedList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");

        sites.addFirst("first");
        sites.addLast("end");
        System.out.println(sites);
        sites.removeFirst();
        sites.remove(0);
        System.out.println(sites);
    }
}
