package com.chen.尚硅谷.java8新特性.微信博客;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

/**
 * @author chenchen
 * @date 2022-01-14 16:09
 */
public class PredicateTest {
    /*
    判断型函数接口
     */

    public static  boolean checkTrue(String s, Predicate<String> pre1, Predicate<String> pre2){
        // test 方法用来判断，真则true，假则false
        // and or
        // return pre1.test(s) && pre2.test(s);
        return pre1.or(pre2).test(s);
    }

    @Test
    public void test1(){

        String str = "abcdefg";
        boolean b = checkTrue(str,(s)->{
            return str.length()<5;
        },(s)->{
            return str.contains("a");
        });
        System.out.println(b);
        //对其进一步优化
        boolean c = checkTrue(str,s-> str.length()>5,s-> str.contains("a"));
        System.out.println(c);
    }
}
