package com.chen.尚硅谷.多线程JUC.exer;

public class ThreadDemo {
    //创建两个分线程，一个遍历奇数，一个遍历偶数
    public static void main(String[] args) {
        ThreadFor threadFor1 = new ThreadFor();
        threadFor1.start();

        //匿名子类的形式
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i%2==1){

                        System.out.println(Thread.currentThread().getName()+"==="+i);
                    }
                }
            }
        }.start();


    }

    static class ThreadFor extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                if(i%2==0){
                    System.out.println(Thread.currentThread().getName()+"==="+i);
                }
            }
        }
    }
}
