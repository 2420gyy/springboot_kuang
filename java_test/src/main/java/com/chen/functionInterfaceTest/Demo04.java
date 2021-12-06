package com.chen.functionInterfaceTest;

import java.util.function.Supplier;

/**
 * @author chenchen
 * @date 2021-12-01 23:34
 */
public class Demo04 {
    public static void main(String[] args) {
        //供给型接口 没有参数，只有返回值
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                System.out.println("get()");
                return 1024;
            }
        };
        Supplier<String> supplier1 = ()->{
          return  "没有输入，只有返回";};
        Supplier<String> supplier2 = () -> "ss";
        System.out.println(supplier.get());
        System.out.println(supplier1.get());
        System.out.println(supplier2.get());
    }
}
