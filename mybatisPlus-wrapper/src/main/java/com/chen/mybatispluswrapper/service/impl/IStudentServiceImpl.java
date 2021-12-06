package com.chen.mybatispluswrapper.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.mybatispluswrapper.entity.Student;
import com.chen.mybatispluswrapper.mapper.IStudentMapper;
import com.chen.mybatispluswrapper.query.QueryObject;
import com.chen.mybatispluswrapper.service.IStudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ChenChen
 * @since 2021-10-12
 */
@Service
public class IStudentServiceImpl extends ServiceImpl<IStudentMapper, Student> implements IStudentService {

    @Autowired
    private IStudentMapper IStudentMapper;

    @Override
    public PageInfo<Student> QueryByPage(QueryObject go) {

        System.out.println(go.getCurrentPage()+" "+go.getPageSize());
        PageHelper.startPage(go.getCurrentPage(),go.getPageSize());
        List<Student> list = IStudentMapper.QueryByPage(go);
        list.forEach(System.out::println);
        System.out.println("==============");
        return new PageInfo<Student>(list);
    }

    @Override
    public List<Student> testForEach(List<Integer> ttd) {
        List<Student> list = IStudentMapper.testForEach(ttd);
        return list;
    }
}
