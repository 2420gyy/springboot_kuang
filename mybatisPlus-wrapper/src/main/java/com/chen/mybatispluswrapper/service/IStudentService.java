package com.chen.mybatispluswrapper.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.mybatispluswrapper.entity.Student;
import com.chen.mybatispluswrapper.query.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ChenChen
 * @since 2021-10-12
 */
public interface IStudentService extends IService<Student> {
    PageInfo<Student> QueryByPage(QueryObject go);

    List<Student> testForEach(List<Integer> ttd);

}
