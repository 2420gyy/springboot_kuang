package com.chen;

import com.chen.Enum测试.EnumSeason;

/**
 * @author chenchen
 * @date 2021-11-13 10:53
 */
public class EnumTest {

    public static void main(String[] args) {
        EnumSeason autumn = EnumSeason.AUTUMN;
        System.out.println(autumn);//AUTUMN
        String code = EnumSeason.SPRING.getCode();
        String code1 = EnumSeason.AUTUMN.getCode();
        System.out.println(code);

    }


}
