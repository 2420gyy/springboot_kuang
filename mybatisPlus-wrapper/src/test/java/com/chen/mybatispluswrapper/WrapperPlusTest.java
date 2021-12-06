package com.chen.mybatispluswrapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chen.mybatispluswrapper.entity.Student;
import com.chen.mybatispluswrapper.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class WrapperPlusTest {
    @Autowired
    private IStudentService studentService;

    /*
    lambdaXXX
     */
    @Test
    public void test1(){

    }

//    @Override
//    public List<String> checkUserIsWithNode(List<String> userIds) {
//        Assert.notNull(userIds, "用户id不可为空");
//        LambdaQueryWrapper<SAuUser> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.select(SAuUser::getNodeId);
//        queryWrapper.in(SAuUser::getId, userIds);
//        queryWrapper.eq(SAuUser::getDeleteflag, 0);
//        List<SAuUser> userList = isAuUserService.list(queryWrapper);
//        // 获取用户对应的节点id集合
//        return userList.stream().map(SAuUser::getNodeId).distinct().collect(Collectors.toList());
//    }
    @Test
    public void test2(){
//        获取不同用户不同节点，筛选节点不同的用户
        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Student::getName,Arrays.asList("小明","小红","小张","小李"));

        queryWrapper.select(Student::getId,Student::getTid,Student::getName);

        List<Student> userList = studentService.list(queryWrapper);
        List<Integer> collect = userList.stream().map(Student::getTid).distinct().collect(Collectors.toList());
        collect.forEach(System.out::println);//1 2
    }

}
