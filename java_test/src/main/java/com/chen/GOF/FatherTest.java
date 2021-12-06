package com.chen.GOF;

/**
 * @author chenchen
 * @date 2021-11-26 19:28
 */

public class FatherTest{
    public static void main(String[] args) {
        Child child = new Child();
        child.start();
    }
    //子类再一开始会进入父类的构造方法！！！
}
class Father {
    public Father() {
        start();
    }
    protected void start() {}
}

class Child extends Father {
    private Integer i;

    public Child() {
        i = 1;
        start();
    }

    @Override public void start() {
        System.out.println(i);
    }
}