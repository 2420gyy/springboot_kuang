package com.chen;

import org.junit.Test;

/**
 * @author chenchen
 * @date 2021-11-08 18:44
 */
public class CharacterTest {
    @Test
    public void testsplit(){
        /*
        1、如果用“.”作为分隔的话,必须是如下写法,String.split(“\.”),这样才能正确的分隔开,不能用String.split(“.”);
        2、如果用“|”作为分隔的话,必须是如下写法,String.split(“\|”),这样才能正确的分隔开,不能用String.split(“|”);
        “.”和“|”都是转义字符,必须得加”\”;
        3、如果在一个字符串中有多个分隔符,可以用“|”作为连字符,比如,“acount=? and uu =? or n=?”,把三个都分隔出来,可以用String.split(“and|or”);
         */
        String key ="aaaaaaaaaa" + "_" + "11111111111";
        System.out.println(key);
        String a = key.split("_")[0];
        String b = key.split("_")[1];
        System.out.println(a);
        System.out.println(b);

        System.out.println("===============");

        // String[] aa = "aaa|bbb|ccc".split("|");
        String[] aa = "aaa|bbb|ccc".split("\\|"); //这样才能得到正确的结果
        for (int i = 0 ; i <aa.length ; i++ ) {
            System.out.print("-"+aa[i]);
        }
        System.out.println("");
        // String[] bb = "aaa*bbb*ccc".split("*");
        String[] bb = "aaa*bbb*ccc".split("\\*"); //这样才能得到正确的结果
        for (int i = 0 ; i <bb.length ; i++ ) {
            System.out.println("-"+bb[i]);
        }
    }
}
