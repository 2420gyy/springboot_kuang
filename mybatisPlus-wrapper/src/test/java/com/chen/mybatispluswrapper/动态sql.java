package com.chen.mybatispluswrapper;

import com.chen.mybatispluswrapper.entity.User;
import com.chen.mybatispluswrapper.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

@SpringBootTest
public class 动态sql {

    @Resource
    private IUserService userService;

    @Test
    public void testIf(){
        User user = new User();
        user.setAge(12);
        user.setPwd("");
        //注意这里的拼接。。。。。
        List<User> user1 = userService.findUserByNameAndPwd(user);
        user1.forEach(System.out::println);
        System.out.println("=======传入空值=======");
        //记住实际业务可以把if写在外面
        //这里new的user是有默认值的！！！
        User user2 = null;
        List<User> user22 = userService.findUserByNameAndPwd(user2);
        user22.forEach(System.out::println);
    }
    @Test
    public void testChoose(){

    }

    @Test
    public void testWhere(){
        User user = new User();
        user.setPwd("java");
        user.setName("i");
        List<User> user1 = userService.findUserByPwd(user);
        user1.forEach(System.out::println);
    }
    @Test
    public void testMaybe(){
        User user = new User();
        user.setName("i");
        List<User> user1 = userService.testMaybe(user);
        user1.forEach(System.out::println);
    }
    @Test
    public void testAboutTime(){
        Map<String,Object> result = new HashMap<>();
        String birth = "2016-03-04";
        Map<String,Object> list = userService.testAboutTime(birth);
        //注意输出map
        Collection<Object> values = list.values();
        Iterator<Object> iterator = values.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void testBind(){
        String inputValue = "xiao";
        List<User> userList = userService.findUserByLikeName(inputValue);
        userList.forEach(System.out::println);

        System.out.println("========================");
        User user = new User();
        user.setName("xiao");

        List<User> user1 = userService.findUserByUser(user);
        user1.stream().forEach(System.out::println);
    }



}
