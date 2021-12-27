package com.chen.jsonTest;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author chenchen
 * @date 2021-12-26 20:12
 */
public class StringOperation {
    @Test
    public void test(){
        // https://www.cnblogs.com/wqbin/p/11234659.html
        // 要求: 指定长度，不足前面补0
        String code = String.format("%06d",Integer.parseInt("8907"));
        System.out.println(code);
    }
    @Test
    public void test2(){
        // 要求 生成指定范围的随机数netInt(r - l + 1) + l
        int max=20;
        int min=10;
        Random random = new Random();

        int a = random.nextInt(max - min + 1) + min;
        System.out.println(a);

        // 对(20-10+1)取模得到[0-10]之间的随机数
        int s = random.nextInt(max)%(max-min+1) + min;
        System.out.println(s);
    }



}
