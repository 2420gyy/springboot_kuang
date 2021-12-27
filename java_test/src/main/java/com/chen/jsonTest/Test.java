package com.chen.jsonTest;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
 @Data
 @NoArgsConstructor
 private static class user {
  private String name;
  private String age;
  private List<course> courseList;

  public user(String name, String age, List<course> courseList) {
   this.name = name;
   this.age = age;
   this.courseList = courseList;
  }
 }

 @Data
 private static class course {
    private String courseName;

  public course(String courseName) {
   this.courseName = courseName;
  }

  public course() {
  }
 }


  public static void main(String[] args) {
  List<user> a = new ArrayList();
   a.add(new user("zs", "18",null));
   a.add(new user("ls", "19",null));
   //
   // a.forEach(System.out::println);
   //
   //
   //
   //
   // List<user> collect = a.stream().map(item -> {
   //  user u = new user();
   //  u.setAge(item.getAge() + "!");
   //  u.setName(item.name);
   //  return u;
   // }).collect(Collectors.toList());
   //
   // collect.forEach(System.out::println);


   List<user> collect2 = new ArrayList<>();
   collect2 = new ArrayList<>();
     collect2.stream().forEach(item -> {
     List<course> na = Arrays.asList(new course("1"));
     item.setCourseList(na);
   });

   collect2.forEach(System.out::println);


  }
}