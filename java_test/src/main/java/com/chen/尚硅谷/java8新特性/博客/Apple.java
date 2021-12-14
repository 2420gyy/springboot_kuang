package com.chen.尚硅谷.java8新特性.博客;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenchen
 * @date 2021-12-13 11:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apple {
    private String color;
    private int weight;
    void get(){
        System.out.println("lll");
    }
}
