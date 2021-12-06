package com.chen.GOF;

/**
 * @author chenchen
 * @date 2021-11-24 10:18
 */
public class GOFTest {

    // public static void hear1(Animal animal){
    //     // 可以传入实现了Anima接口的任意一种子类
    //     animal.makeSound();
    // }

    public static void main(String[] args) {

        Animal animal1 = new Chicken();
        Animal animal2 = new Pig();
        animal1.makeSound();
        animal2.makeSound();

        Cow cow = new Cow();
        cow.makeSound();

        // hear1(new Chicken());
        // hear1(new Cow());
    }
}
