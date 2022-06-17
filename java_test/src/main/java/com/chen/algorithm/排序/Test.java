package com.chen.algorithm.排序;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author chenchen
 * @date 2022-04-26 23:49
 */
public class Test {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(LocalDate.now()); // 2022-04-26
        LocalDate localDate = LocalDate.of(1999, 9, 9);
        System.out.println(LocalDate.of(1999, 9, 9));

        Test.showThisMonth();
    }

    private static void showThisMonth() {
        System.out.print("m  t  w  t  f  s  s");
        System.out.println();
        // 日历格式 且当前日特数表示
        LocalDate now = LocalDate.now();
        String today = now.getDayOfMonth() + "*";
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        System.out.println(dayOfWeek);
    }

}
