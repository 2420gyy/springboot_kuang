package com.chen.子烁设计模式;

import org.junit.jupiter.api.Test;

/**
 * @author chenchen
 * @date 2021-12-02 13:47
 */
public class IntegerTest {
    // byte short char int long float double boolean
    public static void main(String[] args) {
        int a = 2020;
        Integer b = 2020;
        System.out.println(a == b.intValue()); // true
        // System.out.println(a == b); // true 实际有一个自动拆箱的过程
        Integer c = 2020;
        Integer d = 2020;
        System.out.println(c == d);
        System.out.println("equals比较" + c.equals(d));
        Integer e = 20;
        Integer f = 20;
        System.out.println(e == f);
    }

    @Test
    public void test() {
        int a = 100;
        // 装箱
        Integer integer = Integer.valueOf(a);
        // 拆箱
        int i = integer.intValue();

        /**
         * public static Integer valueOf(int i) {
         *         if (i >= IntegerCache.low && i <= IntegerCache.high)
         *             return IntegerCache.cache[i + (-IntegerCache.low)];
         *         return new Integer(i);
         *     }
         */
        //  -XX:AutoBoxCacheMax=size
        //
        Integer c = Integer.valueOf(2020);
        Integer d = Integer.valueOf(2020);
        System.out.println(c == d);
    }
}
