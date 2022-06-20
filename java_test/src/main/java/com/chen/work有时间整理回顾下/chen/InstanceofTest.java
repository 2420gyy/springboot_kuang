package com.chen.work有时间整理回顾下.chen;

import com.github.pagehelper.Page;

import java.util.ArrayList;
import java.util.List;

public class InstanceofTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list1 = new Page<>();
        // 左边是对象，右边是类 当对象是右边类或子类所创建对象时，返回true
        if(list instanceof Page){
            // 这里不行的原因是 list instanceof Page ，Page是 List的子类；List不是Page的子类
            System.out.println("true");
        }
        // 它左边的对象是否是它右边的类的实例
        if(list1 instanceof Page){
            System.out.println("true1");
        }
        Page<String> pag1 = new Page<>();
        if(pag1 instanceof List){
            System.out.println("true2");
        }

    }
}
