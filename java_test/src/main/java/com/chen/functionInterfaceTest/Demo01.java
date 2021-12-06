package com.chen.functionInterfaceTest;

import java.util.function.Function;

/**
 * @author chenchen
 * @date 2021-12-01 23:11
 */
public class Demo01 {
    public static void main(String[] args) {
        // 工具类，输出输入的值
        Function function = new Function<String,String>() {
            @Override
            public String apply(String str) {
                return str;
            }
        };
        Function function2 = (s)->{return s;};
        Function function3 = str->str;
        System.out.println(function.apply("sss"));
        System.out.println(function2.apply("sss"));
        System.out.println(function3.apply("sss"));
    }
}
