package com.chen.work有时间整理回顾下.递归;

public class Leet {
    public static void main(String[] args) {
        System.out.println(" "+test05(7));
    }

    static boolean test02(int n){
        return (n&(n-1))==0?true:false;
    }

    static boolean test04(int n){
        if(n==1) return true;
        if(n==0) return false;
        if(n%2!=0) return false;
        return test04(n/2);
    }
    // n向下除的方法
    static boolean test05(int n){
        while (n>1){
            if(n%2!=0){ // 奇数情况
                return false;
            }
            n = n/2;
        }
        return true;

    }

    static boolean test03(int n){
        // 有点巧。。。 还有n向下除的方法，除到最后。递归也是这样的本质
        int x = 1;
        while (x < n) {
            x = x * 2;
        }
        return x == n;
    }

    // 1 2 4 8 16
    // 0 2*1 / 1 2*1 2 2*2 3 2*4 2*8
    static boolean test(int n){
        if(n == 0) return false;
        if(n == 1) return true;
        if(n == 2) return true;
        int flag = 2;
        if(n%2 == 0){
            for (int i = (n/2+1); i < n; i++) {
                if(2*flag == n){
                    return true;
                }
                flag*=2;
            }
        }
        return false;
    }
}
