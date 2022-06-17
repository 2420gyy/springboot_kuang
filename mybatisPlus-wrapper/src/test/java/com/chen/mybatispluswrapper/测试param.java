package com.chen.mybatispluswrapper;

import com.chen.mybatispluswrapper.entity.Teacher;
import com.chen.mybatispluswrapper.mapper.TeacherMapper;
import com.chen.mybatispluswrapper.vo.TeacherVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenchen
 * @date 2022-05-29 23:34
 */
@SpringBootTest
public class 测试param {

    @Resource
    private TeacherMapper teacherMapper;



    @Test
    public void test0(){

        Teacher teacher = teacherMapper.test0(1);
        System.out.println(teacher);
        System.out.println("======");
    }
    
    @Test
    public void test1(){
        int tid = 3;
        String tName = "老师";
        /*
         */
        Teacher teacher = teacherMapper.test(tid,tName);
        System.out.println(teacher);
    }

    @Test
    public void test2(){
        Teacher teacher1 = teacherMapper.test1("李","老师");
        System.out.println(teacher1);
    }

    @Test
    public void test3(){
        Teacher teacher2 = new Teacher(2, "老师");
        String sName = "小明";
        // 找到id为2，name带有老师
        List<TeacherVO> teacherVOList = teacherMapper.test2(sName,teacher2);
        System.out.println(teacherVOList);
    }

}
