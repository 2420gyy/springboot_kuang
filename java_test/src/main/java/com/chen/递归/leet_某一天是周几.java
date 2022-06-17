package com.chen.递归;

/**
 * @author chenchen
 * @date 2022-01-04 17:39
 */
public class leet_某一天是周几 {
    public static void main(String[] args) {
        // 1971 年1月1日为星期五
        // int day=18,month=7,year=1999; // 1-Friday-Sunday
        // int day=28,month=1,year=1971; //
        int day=29,month=2,year=2016; // 1-Friday-Sunday
        // int day=21,month=12,year=2022; // 1-Friday-Sunday
        int sum = 0 ,x=28;
        if(cao(year)){
            x=+1;
        }
        int[] months = {31,x,31,30,31,30,31,31,30,31,30,31};
        String[] weeks ={"Friday","Saturday","Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};

        for (int i=1971;i<year;i++){
            if(cao(i)){
                // 366天
                sum+=366;
            }else{
                sum+=365;
            }
        }
        for (int i = 1; i <month; i++) {
            sum+=months[i-1];
        }


        sum+=day-1;
        System.out.println(sum);

        System.out.println(weeks[sum%7]);
    }
    public static boolean cao(int k){
        return k%400 == 0 || (k%4 == 0 && k %100 != 0);
    }
}
