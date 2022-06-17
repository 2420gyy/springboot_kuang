package com.chen.work有时间整理回顾下;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _2037学生有位置 {
    public static void main(String[] args) {
        List<Integer> seats = Arrays.asList(5, 9,13);
        List<Integer> student = Arrays.asList(2, 3,4);
        // 4+7 8+3 左边的直接减，右边的也是加上直接减
        // 中间的情况 取临近的位置坐
        // 3 5 7 9 13 15

        sort(seats,student);
//        sort2(seats,student);

    }
    public static void sort2(int[] seats,int[] student){
        List<Integer> seatsL = new ArrayList<>();
        for (int i = 0; i < seats.length; i++) {
            seatsL.add(seats[i]);
        }
        List<Integer> studentL = new ArrayList<>();
        for (int i = 0; i < student.length; i++) {
            studentL.add(student[i]);
        }
        List<Integer> seatsSort = new ArrayList<>();
        seatsL.sort(Comparator.comparing(Integer::intValue));
        seatsSort = seatsL;
        List<Integer> studentSort = new ArrayList<>();
        studentL.sort(Comparator.comparing(Integer::intValue));
        studentSort = studentL;
        int flag = 0;
        for (int i = 0; i < seatsSort.size(); i++) {
            Integer integer = studentSort.get(i);
            flag += integer>seatsSort.get(i)?integer-seatsSort.get(i):seatsSort.get(i)-integer;
        }
        System.out.println(flag);

    }


    public static void sort(List<Integer> seats,List<Integer> student){
        List<Integer> all = new ArrayList<>();
        List<Integer> seatsSort = new ArrayList<>();
        seats.sort(Comparator.comparing(Integer::intValue));
        seatsSort = seats;
        List<Integer> studentSort = new ArrayList<>();
        student.sort(Comparator.comparing(Integer::intValue));
        studentSort = student;

        all.addAll(seats);
        all.addAll(student);
        all.sort(Comparator.comparing(Integer::intValue));
        System.out.println(all);
        int flag = 0;
        for (int i = 0; i < seats.size(); i++) {
            // 考虑两边的情况
            if(studentSort.get(studentSort.size() - 1) <= seatsSort.get(0) || studentSort.get(0)>=seatsSort.get(seatsSort.size()-1)){
                if(seats.get(i)>student.get(i)){
                    flag += seats.get(i) - student.get(i);
                }else {
                    flag += student.get(i) - seats.get(i);
                }
            }else {
                // 位于中间的情况

            }
        }
        System.out.println(flag);
    }

}
