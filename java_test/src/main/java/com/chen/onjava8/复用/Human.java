package com.chen.onjava8.复用;

/**
 * @author chenchen
 * @date 2022-04-24 15:35
 */
public class Human extends Animal{
    public static void main(String[] args) {
        Human human = new Human();
        Integer height = human.height;
        human.run();
        human.pa(); // protected
        human.myMethod();
    }

    public void myMethod(){
        super.pa();
        this.pa();
    }
}
