package com.chen.work有时间整理回顾下;

public class ThreadLocalTest {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static void main(String[] args) {
        ThreadLocalTest test=new ThreadLocalTest();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                //先给对象赋值，再取出这个值
                test.setMsg(Thread.currentThread().getName()+"的数据");
                System.out.println(Thread.currentThread().getName()+"---->"+test.getMsg());
            }).start();
        }
    }
}
