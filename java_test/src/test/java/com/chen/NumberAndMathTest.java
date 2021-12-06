package com.chen;

import org.junit.Test;

/**
 * @author chenchen
 * @date 2021-11-08 16:43
 */
public class NumberAndMathTest {

    @Test
    public void testxxxValue(){
        Integer a = 12;
        //xxxValue() 将Number对象转为xxx数据类型
        int i = a.intValue();
        //返回 int 原生数据类型
        System.out.println(i);
        Double b = 12.123;
        int i1 = b.intValue();
        System.out.println(i1);//12
    }
    @Test
    public void testcompareTo(){
        /*
        compareTo() 方法用于将 Number 对象与方法的参数进行比较。可用于比较 Byte, Long, Integer等。
        该方法用于两个相同数据类型的比较，两个不同类型的数据不能用此方法来比较。
        public int compareTo( NumberSubClass referenceName )
        referenceName -- 可以是一个 Byte, Double, Integer, Float, Long 或 Short 类型的参数。

        相等返回0   指定的数小于参数返回-1    指定的数大于参数返回1
         */
        Integer x = 5;//指点的数
        int i = x.compareTo(5);
        System.out.println(i);
        int j = x.compareTo(8);
        System.out.println(j);
        int k = x.compareTo(3);
        System.out.println(k);
        System.out.println("========");
        Byte a = 3;//参数
        /*
        valueOf() 方法用于返回给定参数的原生 Number 对象值，参数可以是原生数据类型, String等。
        该方法是静态方法。该方法可以接收两个参数一个是字符串，一个是基数。
        static Integer valueOf(int i)
        static Integer valueOf(String s)
        static Integer valueOf(String s, int radix)
         */
        int i1 = x.compareTo(Integer.valueOf(a));
        int i2 = x.compareTo(a.intValue());
        System.out.println(i1);
        System.out.println(i2);

        Byte aByte = Byte.valueOf(a);
        Byte aByte1 = Byte.valueOf(String.valueOf(x));//无法把 Integer赋值给Byte
        Integer integer = Integer.valueOf("444", 16);
        System.out.println("========");
        System.out.println(aByte);
        System.out.println(aByte1);
        System.out.println(integer);
    }
    @Test
    public void test(){
        //equals() 方法用于判断 Number 对象与方法的参数进是否相等。
        //基本数据类型 ==比较值
        //引用数据类型 ==比较地址
        //类没有覆盖equals方法 比较地址值
        //类覆盖了equals方法 比较对象的值  eg: String
        Integer x = 3;
        Integer y = 4;
        Integer z = 4;
        System.out.println(x.equals(z));
    }
    @Test
    public void testparseInt(){
        /*
        parseInt() 方法用于将字符串参数作为有符号的十进制整数进行解析。
        如果方法有两个参数， 使用第二个参数指定的基数，将字符串参数解析为有符号的整数。
        parseInt(String s): 返回用十进制参数表示的整数值。
         */
        String str = "1234";
        int i = Integer.parseInt(str);
        System.out.println(i+1);
    }
    @Test
    public void testrandom(){
        /*
        random() 方法用于返回一个随机数，随机数范围为 0.0 =< Math.random < 1.0。
         */
        double random = Math.random();
        System.out.println(random);

        double d = 100.675;
        double e = 100.500;
        float f = 100;
        float g = 90f;

        System.out.println(Math.round(d));
        System.out.println(Math.round(e));
        System.out.println(Math.round(f));
        System.out.println(Math.round(g));

        /**
         * round() 方法返回一个最接近的 int、long 型值，四舍五入。
         * round 表示"四舍五入"，算法为Math.floor(x+0.5) ，
         * 即将原来的数字加上 0.5 后再向下取整，所以 Math.round(11.5) 的结果为 12，Math.round(-11.5) 的结果为 -11。
         */
        System.out.println("==========rint()==========");
        /*
        rint() 方法返回最接近参数的整数值。
         */
        double d1 = 100.675;
        double e1 = 100.500;
        double f1 = 100.200;

        double e2 = -100.600;
        double f2 = -100.500;

        System.out.println(Math.rint(d1));
        System.out.println(Math.rint(e1));
        System.out.println(Math.rint(f1));
        System.out.println(Math.rint(e2));
        System.out.println(Math.rint(f2));
        System.out.println("--------------");
        System.out.println(Math.round(d1));
        System.out.println(Math.round(e1));
        System.out.println(Math.round(f1));
        System.out.println(Math.round(e2));
        System.out.println(Math.round(f2));
    }
}
