package com.chen.work有时间整理回顾下.递归;

public class hanoi {

    public static void hanoi(int n, char A, char B, char C) {
        if (n == 1) {
            move(A, C);
        } else {
            hanoi(n - 1, A, C, B);//将n-1个盘子由A经过C移动到B
            move(A, C);             //执行最大盘子n移动
            hanoi(n - 1, B, A, C);//剩下的n-1盘子，由B经过A移动到C
        }
    }

    private static void move(char A, char C) {//执行最大盘子n的从A-C的移动
        System.out.println("move:" + A + "--->" + C);
    }

    public static void main(String[] args) {
        System.out.println("移动汉诺塔的步骤：");
        hanoi(3, 'a', 'b', 'c');
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
}
