package com.chen.GOF;

/**
 * @author chenchen
 * @date 2021-11-24 10:12
 */
public class Cow extends Animals implements Animal{


    @Override
    public void makeSound() {
        System.out.println("哞哞~");
    }
}
