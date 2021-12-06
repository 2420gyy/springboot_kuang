package com.chen.mybatispluswrapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.mybatispluswrapper.entity.Student;
import com.chen.mybatispluswrapper.entity.Teacher;
import com.chen.mybatispluswrapper.mapper.IStudentMapper;
import com.chen.mybatispluswrapper.mapper.TeacherMapper;
import com.chen.mybatispluswrapper.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class 编程不良人MBPTest {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private IStudentMapper iStudentMapper;

    @Autowired
    private IStudentService iStudentService;

    @Test
    public void test1(){
        List<Teacher> teachers = teacherMapper.selectList(null);//查所有
        Teacher teacher = teacherMapper.selectById(1);//查询一个
        //条件查询
        /*
        eq/ne 等于，不等
        gt,ge
        lt,le
        like %值%
         */
        QueryWrapper<Teacher> wrapper1 = new QueryWrapper<>();
//        wrapper1.likeRight("name","李");//李%
        wrapper1.like("name","老");
        for (Teacher teacher1 : teacherMapper.selectList(wrapper1)) {
            System.out.println(teacher1);
        }
    }
    @Test
    public void test2(){
//        Teacher teacher = new Teacher();
//        teacher.setId(7);
//        teacher.setName("鸣人改");
//        teacherMapper.insert(teacher);
//        LambdaQueryWrapper<Teacher> wq = new LambdaQueryWrapper<>();
//        wq.orderByDesc(Teacher::getId).last("limit 1");
//        Teacher teacher = teacherMapper.selectOne(wq);
//        System.out.println(teacher);

        String name = "鸣人改";
        LambdaQueryWrapper<Teacher> wq1 = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<Teacher> eq = wq1.eq(Teacher::getName, name);
        Teacher teacher1 = teacherMapper.selectOne(eq);

        System.out.println(teacher1);

    }
    @Test
    public void test3(){
        Student student = new Student();
//        student.setId(null);//主键自增设置0
        student.setId(0);
        student.setName("波风水门");
        student.setTid(1);
//        iStudentMapper.insert(student);

        Student student1 = iStudentMapper.selectById(9);
        student1.setName("佐助");
        iStudentMapper.updateById(student1);//传参要一个obj
    }
    @Test
    public void test4(){
//        批量修改 如果不想改变其他项，设置未null
        Student student1 = iStudentMapper.selectById(9);
//        可以直接new一个对象更好
        student1.setName("佐助");
        student1.setTid(2);
        QueryWrapper<Student> updateWrapper = new QueryWrapper<>();
        updateWrapper.eq("tid",3);
        iStudentMapper.update(student1,updateWrapper);
    }
    @Test
    public void test5(){
        iStudentMapper.deleteById("-8282111");//两种传参方式，根据符合的实体去删除
    }
    @Test
    public void testFindPage(){
        //参数一 当前页current 1，参数二 每页的记录数size 10
        IPage<Student> page = new Page<>(1,3);
        IPage<Student> studentIPage = iStudentMapper.selectPage(page, null);//page，wrapper
        System.out.println("总的记录数 : "+studentIPage.getTotal());
        studentIPage.getRecords().forEach(student -> System.out.println("stu = "+student));
    }
    /*
    多数据源，使用@DS注解，搜，jar
     */
    @Test
    public void testForeach(){
        int powerIds= 1;
        List<Integer> li = Arrays.asList(powerIds);
//        List<Integer> li = new ArrayList<>();
//        li.add(1);
        System.out.println(li);
        for (Student testForEach : iStudentService.testForEach(li)) {
            System.out.println(testForEach);
        }
    }
    @Test
    public void testForLike(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1807695871);
        list.add(29396993);
        iStudentService.removeByIds(list);
    }
}
