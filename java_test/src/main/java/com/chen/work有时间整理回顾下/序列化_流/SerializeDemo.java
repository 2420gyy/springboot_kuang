package com.chen.work有时间整理回顾下.序列化_流;

import java.io.*;

public class SerializeDemo {
    // 注意： 当序列化一个对象到文件时， 按照 Java 的标准约定是给文件一个 .ser 扩展名。
    public static void main(String[] args) throws IOException {
        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 101;

        String pathname = System.getProperty("user.dir")+"/employee.ser";
        File file = new File(pathname);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);

        out.writeObject(e);
        out.close();
        fileOutputStream.close();
    }
}
