package com.chen.mybatispluswrapper;


import com.chen.mybatispluswrapper.DI注入测试.Svc;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author chenchen
 * @date 2021-11-13 9:25
 */
@SpringBootTest
public class SimpleTest {

    @Resource(name = "svcA")
    Svc svc;

    @Test
    public void test1(){
        svc.sayHello();
    }


}
