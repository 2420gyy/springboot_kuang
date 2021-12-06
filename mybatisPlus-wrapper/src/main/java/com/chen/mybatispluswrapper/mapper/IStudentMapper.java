package com.chen.mybatispluswrapper.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.mybatispluswrapper.entity.Student;
import com.chen.mybatispluswrapper.query.QueryObject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ChenChen
 * @since 2021-10-12
 */
@Mapper
public interface IStudentMapper extends BaseMapper<Student> {
    List<Student> QueryByPage(QueryObject go);

    List<Student> testForEach(List<Integer> ttd);

}
