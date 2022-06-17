package com.chen.jsonTest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author chenchen
 * @date 2021-12-26 20:12
 */
public class StringOperation {
    @Test
    public void test(){
        // https://www.cnblogs.com/wqbin/p/11234659.html
        // 要求: 指定长度，不足前面补0
        String code = String.format("%06d",Integer.parseInt("8907"));
        System.out.println(code);
    }
    @Test
    public void test2(){
        // 要求 生成指定范围的随机数netInt(r - l + 1) + l
        int max=20;
        int min=10;
        Random random = new Random();

        int a = random.nextInt(max - min + 1) + min;
        System.out.println(a);

        // 对(20-10+1)取模得到[0-10]之间的随机数
        int s = random.nextInt(max)%(max-min+1) + min;
        System.out.println(s);
    }
    @Test
    public void test3(){
        String a1 = "这.是.一.个.例子";
        String a2 = "这|是|一.个例.子";
        String a3 = "acount=? and uu =? or n=?";

        // for (String s : a1.split("\\.")) {
        //     System.out.println(s);
        // }
        for (String s : a2.split("\\||\\.")) {
            System.out.println(s);
        }
        // for (String s : a3.split("and|or")) {
        //     System.out.println(s);
        // }
    }
    @Test
    public void test4(){
        /**
         *  1.length()方法是针对字符串来说的，要求一个字符串的长度就要用到它的length()方法；
         *  2.length属性是针对Java中的数组来说的，要求数组的长度可以用其length属性；
         *  3.java中的size()方法是针对泛型集合说的,如果想看这个泛型有多少个元素,就调用此方法来查看!
         */
        String []list={"ma","cao","yuan"};
        String a="macaoyuan";
        System.out.println(list.length);
        System.out.println(a.length());
        List array=new ArrayList();
        array.add(a);
        System.out.println(array.size());
    }
    @Test
    public void test5(){
        // 模拟位图操作
        int[] a= {4,7,2,5,3};

        int[] n= {0,0,0,0,0,0,0,0};

        for (int i=0;i<a.length;i++){
            n[a[i]] = 1;
        }
        for (int i = 0 ;i<n.length;i++){
            if(n[i]!=0){
                System.out.println(i);
            }
        }

    }
    @Test
    public void test6(){
        // 计数排序
        int arr[] = {2, 5, 3, 0, 2, 3, 0, 3};
        int length = arr.length;

        // 找到最大最小值 减小空间损失
        // 核心思想是: 确定数据的最大和最小值，确定连续的需要的hash空间大小，（而不是取数据长度为数组，即0的长度）
        int min = arr[0],max = arr[0];
        for (int i = 0; i < length; i++)
        {
            if (arr[i] < min)
                min = arr[i];

            if (arr[i] > max)
                max = arr[i];
        }
        // 确定区间
        int range = max - min + 1;
        System.out.println(range +" "+ max +" "+ min);

        int hash[] = new int[range];

        for (int i=0;i<length;i++){
            hash[arr[i] - min]++;
        }
        for (int i : hash) {
            System.out.print(i);
        }
        System.out.println();
        for (int i = 0,j = 0; i<range;i++){
            while(hash[i]!=0){
                arr[j++] = i+min;
                hash[i]--;
            }
        }
        for (int i : arr) {
            System.out.print(i);
        }


    }
    @Test
    public void test7(){
        // 计数排序只能针对整数排序，所有针对字符串的基数排序就诞生了


    }
    @Test
    public void test8(){


    }




}
