package com.chen.work有时间整理回顾下.序列化_流;

import lombok.Data;

@Data
public class Employee implements java.io.Serializable
{
   /*
   该类必须实现 java.io.Serializable 接口。
   该类的所有属性必须是可序列化的。
   检验一个类的实例是否能序列化十分简单， 只需要查看该类有没有实现 java.io.Serializable接口。
    */
   public String name;
   public String address;
   public transient int SSN;
   public int number;

   public void mailCheck()
   {
      System.out.println("Mailing a check to " + name
                           + " " + address);
   }
}