package com.chen.Date;

import java.util.Calendar;
import java.util.Date;

/**
 * @author chenchen
 * @date 2021-12-31 10:01
 */
public class SDTest {
    public static void main(String[] args) {
        // 获得当前时间并设置时区为上海
        Date now = new Date();
        // 当月的第一天的0时0分0秒0纳秒
        Date start = SDTest.getMonthBegin(now);
        // 下一个月的第一天的0时0分0秒0纳秒
        Date end = SDTest.getMonthEnd(now);

        System.out.println();
    }
    /**
     * 获取指定日期所在月份开始的时间
     * lkeji
     * @return
     */
    private static Date getMonthBegin(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        //设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH, 1);
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND,0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);

        return c.getTime();
    }

    /**
     * 获取指定日期所在月份结束的时间
     * @return
     */
    private static Date getMonthEnd(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);

        //设置为当月最后一天
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        //将小时至23
        c.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至59
        c.set(Calendar.MINUTE, 59);
        //将秒至59
        c.set(Calendar.SECOND, 59);
        //将毫秒至999
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }
}
