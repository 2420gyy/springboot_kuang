package com.chen.尚硅谷.泛型;

import org.junit.jupiter.api.Test;

/**
 * @author chenchen
 * @date 2021-12-19 22:41
 */
public class 转型问题 {

    /*
    向上转型：子类对象转为父类，父类可以是接口。公式：Father f = new Son();Father是父类或接口，son是子类。
     */
    @Test
    public void test(){
        c c = new c();
        t show = c.show();
        //  向下转型：父类对象转为子类。公式：Son s = (Son)f;
        c show1 = (c) show;

    }
}
class c implements t{

    @Override
    public t show() {
        return null;
    }
}
interface t{
    t show();
}
