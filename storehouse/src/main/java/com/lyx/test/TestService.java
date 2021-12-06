package com.lyx.test;

import com.lyx.model.Page;
import org.junit.Test;

import java.lang.reflect.Field;

public class TestService {

    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        System.out.println(ac);
//        GoodsTitleService goodsTitleService = (GoodsTitleService) ac.getBean("goodsTitleService");
//        System.out.println(goodsTitleService);
//        List<TGoodsTitle> goodsTitles = goodsTitleService.findAllTGoodsTitle();
//        for (TGoodsTitle goodsTitle : goodsTitles) {
//            System.out.println(goodsTitle);
//        }
        Page p = new Page();
        Field f = p.getClass().getDeclaredField("state");

        f.setAccessible(true);

        f.set(p, 10);
        System.out.println(p.getLineCount());

    }
}
