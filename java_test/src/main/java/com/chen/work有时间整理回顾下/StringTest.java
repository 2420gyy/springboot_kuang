package com.chen.work有时间整理回顾下;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenchen
 * @date 2022-06-16 16:53
 */
public class StringTest {

    public static void main(String[] args) {
        String attachmentType = "clue,sss";
        String[] split = attachmentType.replace("'","").split(",");
        List<String> stringList = new ArrayList<>();
        for (String s : split) {
            stringList.add(s);
        }
        stringList.add("default");
        System.out.println(stringList);


        // 强制转为字符串。。
        byte[]  b = {99,2,3,4};
        String str = new String(b);
        System.out.printf(str);


    }
}
