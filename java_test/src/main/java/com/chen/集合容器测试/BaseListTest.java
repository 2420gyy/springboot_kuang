package com.chen.集合容器测试;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenchen
 * @date 2021-12-04 10:28
 */
public class BaseListTest {
    /**
     * 新建一个list对象，默认值是空，而非null；
     * 举个形象的例子，我有一个空着的水杯（list），而你没有，那你是null，我的size为0。
     * 你想装水就需要自己去买个水杯（new ArrayList();），但是我就可以直接装水（list.add(水)）。
     * 你要是没有杯子直接倒水，水就流出去啦（空指针异常）
     */
    @Test
    public void test1(){
        List<String> stringList = new ArrayList<>();
        if(stringList!=null){
            System.out.println("s1");
        }
        if(stringList.isEmpty()){
            System.out.println("s2");
        }
    }
}
