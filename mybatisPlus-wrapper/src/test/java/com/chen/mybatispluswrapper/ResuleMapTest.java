package com.chen.mybatispluswrapper;

import com.chen.mybatispluswrapper.entity.Stu;
import com.chen.mybatispluswrapper.entity.StuClass;
import com.chen.mybatispluswrapper.mapper.StuClassMapper;
import com.chen.mybatispluswrapper.mapper.StuMapper;
import com.chen.mybatispluswrapper.service.StuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chenchen
 * @date 2021-11-11 0:31
 */
@SpringBootTest
public class ResuleMapTest {

    @Resource
    private StuService stuService;

    //在没有业务的时候采用这种方法简单
    @Autowired
    private StuMapper stuMapper;

    @Autowired
    private StuClassMapper stuClassMapper;

    @Test
    public void test1(){
        int sid = 1;
        Stu stu = stuService.findStudentBySid(sid);
        System.out.println(stu);
    }
    @Test
    public void test2(){
        int cid = 1;
        StuClass stuClassByCid = stuClassMapper.findStuClassByCid(cid);
        System.out.println(stuClassByCid);
    }




    @Test
    public void testn1(){
        List<Stu> allStu = stuMapper.getAllStu();
        //
        Map<String, List<Stu>> collect = allStu.stream().collect(Collectors.groupingBy(Stu::getCourse));
        System.out.println(collect);
        //测试keySet和EntrySet
        collect.keySet().forEach(key->{
            System.out.println(key);
            List<Stu> stus = collect.get(key);
            System.out.println(stus);
        });
    }



    static int[] count = new int[1000];
    @Test
    public void testn2(){
        for (int n = 1; n < 45; n++) {
            int res = f(n);
            System.out.println(res);
        }
    }
    static int f(int n){
        if(n==1) return 1 ;
        if(n==2) return 2 ;
        if(count[n-1]!=0 && count[n-2]!=0){
            return count[n-1]+count[n-2];
        }
        else {
            count[n-1]=f(n-1);
            count[n-2]=f(n-2);
            return count[n-1]+count[n-2];
        }
    }

}
