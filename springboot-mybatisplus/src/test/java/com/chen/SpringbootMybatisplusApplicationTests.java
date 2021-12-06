package com.chen;

import com.chen.Test.entity.S_treenode;
import com.chen.Test.service.IS_treenodeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringbootMybatisplusApplicationTests {

    @Resource
    private IS_treenodeService is_treenodeService;

    @Test
    void contextLoads() {
        List<S_treenode> list = is_treenodeService.getAllTree();
        for (S_treenode s_treenode : list) {
            System.out.println(s_treenode);
        }

    }

}
