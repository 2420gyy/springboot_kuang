package com.chen.尚硅谷.java8新特性.微信博客;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

/**
 * @author chenchen
 * @date 2022-01-14 17:09
 */
// https://blog.csdn.net/qq_29848473/article/details/79554472
public class FunctionTest {

    // Function
    @Test
    public void test1(){
        // 其他: 转换成了对应的数字
        Stream.of('1','2','3').map(n->n+'1').forEach(System.out::println);

        System.out.println("======");
    }
}
