package com.chen.onjava8.复用;

public class Cat extends Animal1 implements persont{




    public void eat(){

        System.out.println("cat我吃鱼");

    }

    @Override
    public void peat() {
        System.out.println("cat重写persont");
    }
}