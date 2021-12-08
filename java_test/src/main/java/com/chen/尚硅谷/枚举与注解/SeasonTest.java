package com.chen.尚硅谷.枚举与注解;

/**
 * @author chenchen
 * @date 2021-12-07 20:30
 */

/**
 * 1.枚举类的理解:类的对象只有有限个，确定的，我们称此类为枚举类
 * 2.当需要定义一组常量时，使用枚举类
 * 3.如果枚举类中只有一个对象，则可以作为单例模式的实现方式
 *
 * 方式一：自定义枚举类
 * 方式二：使用enum关键字定义
 *
 */
public class SeasonTest {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN.getSeasonName());
        PunishBaseTypeEnum common = PunishBaseTypeEnum.COMMON;
        System.out.println(common.toString());
        System.out.println(PunishBaseTypeEnum.EASY.getCode());
        System.out.println("===========");
        // enum 的方法
        // values 获得所有枚举值值
        PunishBaseTypeEnum[] values = PunishBaseTypeEnum.values();
        for (PunishBaseTypeEnum value : values) {
            System.out.println(value);// COMMON EASY
        }
        //Thread 这个获得所有枚举值值
        Thread.State[] values1 = Thread.State.values();
        // valueOf ...
        System.out.println(PunishBaseTypeEnum.valueOf("COMMON")); // COMMON


    }
}
enum PunishBaseTypeEnum{
    // 1.枚举类的对象，用逗号分隔
    COMMON("01","普通程序"),
    EASY("02","简易程序");

    // 2.声明对象的属性
    private String code;
    private String value;

    PunishBaseTypeEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}

class Season{
    // 1.声明Season对象的属性
    private final String seasonName;
    private final String seasonDesc;
    // 2. 私有化类的构造器
    private Season(String seasonName,String seasonDesc){
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;
    }
    // 3.提供当前枚举类的多个对象 声明为 public static final 的
    public static final Season SPRING = new Season("春天","a");
    public static final Season SUMMER = new Season("夏天","b");
    public static final Season AUTUMN = new Season("秋天","c");
    public static final Season WINTER = new Season("冬天","d");

    // 4.其他诉求 获取枚举对象的属性值
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
    // 5.

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}