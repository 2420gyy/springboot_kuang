package com.chen.mybatispluswrapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.mybatispluswrapper.entity.Student;
import com.chen.mybatispluswrapper.mapper.IStudentMapper;
import com.chen.mybatispluswrapper.query.QueryObject;
import com.chen.mybatispluswrapper.service.IStudentService;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusWrapperApplicationTests {

    @Resource
    private IStudentMapper IStudentMapper;

    @Test
    public void test1() {
        List<Student> Students = IStudentMapper.selectList(null);
        Students.forEach(System.out::println);
    }

    @Test
    public void test2() {
        QueryWrapper<Student> wrapper1 = new QueryWrapper<>();
        wrapper1.isNotNull("name")
                .ge("id", 4);//大于等于
        IStudentMapper.selectList(wrapper1).forEach(System.out::println);
        System.out.println("============================================");
        QueryWrapper<Student> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("name", "chen");//等于
        Student Student = IStudentMapper.selectOne(wrapper2);//查询一个结果
        System.out.println(Student);
        System.out.println("============================================");
        QueryWrapper<Student> wrapper3 = new QueryWrapper<>();
        wrapper3.between("id", 2, 5);//在什么区间
        Long aLong = IStudentMapper.selectCount(wrapper3);
        System.out.println(aLong);
        System.out.println("============================================");
        QueryWrapper<Student> wrapper4 = new QueryWrapper<>();
        wrapper4.notLike("name", "chen")//%chen%
//                .likeRight("name","小")//right 指%在右边 小%
                .likeLeft("name", "小"); //不能同时用
        List<Map<String, Object>> maps = IStudentMapper.selectMaps(wrapper4);
        maps.forEach(System.out::println);
        System.out.println("============================================");
    }

    @Test
    public void test3() {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.inSql("id", "select id from student where id<3");
        List<Object> objects = IStudentMapper.selectObjs(wrapper);
        objects.forEach(System.out::println);
        QueryWrapper<Student> wrapper2 = new QueryWrapper<>();
        wrapper2.between("id", 3, 4);
        for (Student student : IStudentMapper.selectList(wrapper2)) {
            System.out.println(student);
        }
        System.out.println("=================");
        QueryWrapper<Student> wrapper3 = new QueryWrapper<>();
//        wrapper3.in("id", 2,3,4);//new int []????????????????????????????????????????
//        wrapper3.in("id",new int[]{1,2,3});//不对
        wrapper3.in("id", new Integer[]{1, 2, 3});
        for (Student student : IStudentMapper.selectList(wrapper3)) {
            System.out.println(student);
        }
        System.out.println("=================");
        QueryWrapper<Student> wrapper4 = new QueryWrapper<>();
        wrapper4.inSql("id", "2,3,4");
        for (Student student : IStudentMapper.selectList(wrapper4)) {
            System.out.println(student);
        }
        //好用！！！
        List<Integer> obj1 = new ArrayList<>();
        obj1.add(1);
        obj1.add(2);
        obj1.add(3);
        obj1.add(4);
        QueryWrapper<Student> wrapper5 = new QueryWrapper<>();
        QueryWrapper<Student> obj11 = wrapper5.in("obj1", obj1);
        obj1.forEach(System.out::println);

    }

    @Test
    public void test4() {
        //分页 需要引入插件
        Page<Student> page = new Page<>(1, 2);
        IStudentMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
    }

    //    @Qualifier("")
    @Autowired
    private IStudentService studentService;


    @Test
    public void test5() {
        QueryObject queryObject = new QueryObject();
        queryObject.setNum(3);
        queryObject.setCurrentPage(1);
        queryObject.setPageSize(2);
        PageInfo<Student> page = studentService.QueryByPage(queryObject);
        for (Student obj : page.getList()) {
            System.out.println(obj);
        }

    }
}