package com.chen.compareToTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author chenchen
 * @date 2021-12-03 9:29
 */

/**
 * 可以根据实际情况决定是否重写equals(同样还有hashcode方法)，这样在set或者map类型的集合中需药保证compareTo和equals的一致性。
 *
 * 这里排序过程实际上就是数据结构中的二叉树排序方法，通过二叉树进行排序，然后利用中序遍历的方式把内容依次读取出来。
 * 将第一个内容作为根节点保存，如果后面的值比根节点的值小，则放在根节点的左子树，如果后面的值比根节点的值大，则放在根节点的右子树。
 */
public class MainClass {
    public static void main(String[] args) {
        // Integer integer = new Integer("1");
        // int i1 = integer.compareTo(2);
        // System.out.println(i1);
        List<Integer> list = new ArrayList<>();
        Random rd = new Random();
        for(int i=0;i<10;i++) {
            list.add(rd.nextInt(100));
        }
        for(int i:list) {
            System.out.print(i+" ");
        }
        Collections.sort(list);
        System.out.println("");
        for(int i:list) {
            System.out.print(i+" ");
        }
    }
}
