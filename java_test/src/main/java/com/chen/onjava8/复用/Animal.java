package com.chen.onjava8.复用;

/**
 * @author chenchen
 * @date 2022-04-24 15:33
 */
public class Animal {
    public Integer height;
    private String name;

    public void run(){
        System.out.println("run方法");
    }
    private void fly(){
        System.out.println("fly方法");
    }
    protected void pa(){
        System.out.println("pa方法");
    }

}
