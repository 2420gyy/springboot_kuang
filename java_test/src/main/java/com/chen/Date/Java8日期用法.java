package com.chen.Date;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author chenchen
 * @date 2022-01-17 9:45
 */
public class Java8日期用法 {

    @Test
    public void test1(){
        //获取今天的日期
        LocalDate now = LocalDate.now();
        System.out.println(now);
        //设置日期
        LocalDate of = LocalDate.of(2022, 1, 17);
        System.out.println(of);
        //日期判断
        if(now.equals(of)){
            System.out.println("==日期相等==");
        }
        LocalDate feature = LocalDate.of(2022, 2, 17);
        LocalDate old = LocalDate.of(2021, 2, 17);
        if(now.isBefore(feature)){
            System.out.println("now是f之前的时间");
        }
        if(now.isAfter(old)){
            System.out.println("now是o之后的时间");
        }
        System.out.println("======");
        // 匹配周期性的日期
        // 使用 DayOfWeek、MonthDay、YearMonth 类处理这类日期。
        LocalDate date = LocalDate.of(2023,1,17);
        MonthDay monthDay = MonthDay.of(date.getMonth(), date.getDayOfMonth());
        MonthDay today = MonthDay.from(LocalDate.now());
        if(today.equals(monthDay)) {
            System.out.println("今天已经到特定的日期了");
        } else {
            System.out.println("今天还没有到特定的日期");
        }
    }
    @Test
    public void test2() {
        // 一周、月、年前、后的日期
        LocalDate today = LocalDate.now();
        LocalDate preWeek = today.minus(1, ChronoUnit.WEEKS);
        System.out.println(preWeek);

        LocalDate afterWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println(afterWeek);

        LocalDate preMon = today.minus(1, ChronoUnit.MONTHS);
        System.out.println(preMon);

        LocalDate afterMon = today.plus(1, ChronoUnit.MONTHS);
        System.out.println(afterMon);

        LocalDate preYear = today.minus(1, ChronoUnit.YEARS);
        System.out.println(preYear);

        LocalDate afterYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println(afterYear);
    }
    @Test
    public void test3(){
        // 计算两个日期的间隔了多少天、月
        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.of(22022,4,10);
        Period period = Period.between( date,today);
        System.out.println("间隔了" + period.getMonths() + "月");
        System.out.println("间隔了" + (today.toEpochDay() - date.toEpochDay()) + "天");
        System.out.println("======");
    }
    @Test
    public void test4(){
        // 时间戳
        Instant instant = Instant.now();
        System.out.println(instant);
        System.out.println(instant.toEpochMilli());

        System.out.println("======");
    }
    @Test
    public void test5(){
        // DateTimeFormatter 是一个线程安全的日期和时间格式化器
        String str = "20210109";
        LocalDate formatted = LocalDate.parse(str, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("格式化后的日期为:  "+ formatted);
        System.out.println("======");
        // 形式非常多
        String str2 = "09012021";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        LocalDate date = LocalDate.parse(str2, formatter);
        System.out.print(date);
    }
    @Test
    public void test6(){
        // 判断闰年
        LocalDate today = LocalDate.now();
        if(today.isLeapYear()){
            System.out.println("闰年");
        }else {
            System.out.println("不是闰年");
        }
        System.out.println("======");
    }
    @Test
    public void test7(){
        // 日期转字符串
        LocalDate now = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String str = now.format(format);
        System.out.println(str.replace("-",""));
        System.out.println("======");
    }
    @Test
    public void test8(){
        System.out.println(new Date());
        System.out.println("======");
    }


}
