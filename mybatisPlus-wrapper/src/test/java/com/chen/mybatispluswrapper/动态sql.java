package com.chen.mybatispluswrapper;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.chen.mybatispluswrapper.entity.Teacher;
import com.chen.mybatispluswrapper.entity.User;
import com.chen.mybatispluswrapper.entity.test;
import com.chen.mybatispluswrapper.mapper.TeacherMapper;
import com.chen.mybatispluswrapper.mapper.TestMapper;
import com.chen.mybatispluswrapper.service.IUserService;
import com.chen.mybatispluswrapper.vo.TeacherVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

@SpringBootTest
public class 动态sql {

    @Resource
    private IUserService userService;

    @Resource
    private TeacherMapper teacherMapper;

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
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.setSql("age = age + 1").eq(User::getId, 1);
        userService.update(null,wrapper);
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

    @Resource
    private TestMapper testMapper;

    @Test
    public void test3(){
        test test = new test();
        test.setName("张三");
        testMapper.insertUser(test);
        System.out.println("======");
    }
    @Test
    public void test5(){
        Integer id = 1;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap = testMapper.selectPerson(id);
        // 并返回一个 HashMap 类型的对象，其中的键是列名，值便是结果行中的对应值。
        System.out.println(hashMap);

        System.out.println("======");
    }
    @Test
    public void test6(){
        /*
        INT和CHAR隐式类型转换
         */
        // 1.当查询字段是INT类型，如果查询条件为CHAR，将查询条件转换为INT，
        // 如果是字符串前导都是数字，将截取前导数字用来比较，如果没有前导数字，则转换为0。

        // 2.当查询字段是CHAR/VARCHAR类型，如果查询条件为INT，
        // 将查询字段为换为INT再进行比较，可能会造成全表扫描。
        // char s = 'a';
        String s = "1aaa";
        test test1 = testMapper.selectById(s);
        System.out.println(test1);
        System.out.println("======");
        int i = 222;
        test t1 = new test();
        t1 = testMapper.selectByName(i);
        System.out.println(t1);
    }
    @Test
    public void test7(){
        Integer id = 2;
        String name = "sss";
        test t = testMapper.selectByIdAndName(id,name);
        System.out.println(t);
        System.out.println("======");
    }
    @Test
    public void test8(){
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list.size());
        System.out.println(list);
        System.out.println("======");
    }
    @Test
    public void test9(){
        int tid = 1;
        String tName = "老师";
        Teacher teacher = teacherMapper.test(tid,tName);
        System.out.println(teacher);

        Teacher teacher1 = teacherMapper.test1("李","老师");

        Teacher teacher2 = new Teacher(2, "老师");
        String sName = "小明";
        // 找到id为2，name带有老师
        List<TeacherVO> teacherVOList = teacherMapper.test2(sName,teacher2);
        System.out.println(teacherVOList);
    }



}
