package com.chen.Enum测试;

/**
 * @author chenchen
 * @date 2021-11-13 11:13
 */
public class SimpleEnum {

    public static void main(String[] args) {
        LevelEnum simple = LevelEnum.SIMPLE;
        //SIMPLE
        System.out.println(simple);
    }

}

enum LevelEnum{
    SIMPLE,
    HARD;
}
