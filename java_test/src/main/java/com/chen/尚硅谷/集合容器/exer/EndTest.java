package com.chen.尚硅谷.集合容器.exer;

import org.junit.Test;

import java.util.ArrayList;

public class EndTest {
    //重命名 asr
    //p558
    @Test
    public void 敖丙(){
        ArrayList arrayList = new ArrayList(10);
//        arrayList.set(1,10);
        arrayList.add(0,10);
        arrayList.add(123);
        System.out.println(arrayList.size());
        System.out.println(arrayList);


    }
}
