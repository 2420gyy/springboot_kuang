package com.chen.work有时间整理回顾下.递归;

import java.util.ArrayList;
import java.util.List;

public class hannotaClass {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(0);

        int n = A.size();
        hannota(n,A,B,C);

        System.out.println(A);
        System.out.println(B);
        System.out.println(C);


    }

    static void hannota(int n,List<Integer> A,List<Integer> B,List<Integer> C){
        if(n == 1){
            // 将A移动到C    E remove();
            C.add(A.remove(A.size() - 1));
            return;
        }
        // A [2,1,0]
        hannota(n-1,A,C,B); // 将A上的n-1个盘子经过C 移动到B
        // 将A最后一个(第n-2个)移动到C
        C.add(A.remove(A.size() - 1)); // 这时A是空的。。。
        hannota(n-1,B,A,C); // 将B上面的n-1个通过空的A移动到C

        // 简化移动过程
        //           把n-1个盘子由A 移到 B；
        //           把第n个盘子由 A移到 C；
        //           把n-1个盘子由B 移到 C；
        //     （1）中间的一步是把最大的一个盘子由A移到C上去；
        //　　　（2）中间一步之上可以看成把A上n-1个盘子通过借助辅助塔（C塔）移到了B上，
        //　　　（3）中间一步之下可以看成把B上n-1个盘子通过借助辅助塔（A塔）移到了C上；

    }

}
