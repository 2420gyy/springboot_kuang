package com.chen.functionInterfaceTest;

import java.util.function.Consumer;

/**
 * @author chenchen
 * @date 2021-12-01 23:28
 */
public class Demo03 {
    public static void main(String[] args) {

    // 消费型接口 只有输入,没有返回值
    Consumer<String> consumer = new Consumer<String>() {
        @Override
        public void accept(String str) {
            System.out.println(str);
        }
    };
    Consumer consumer1 = str -> System.out.println(str);
    consumer.accept("输入");
    consumer1.accept("测试");
    }
}
