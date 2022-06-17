package com.chen.Test.mapper;

import com.chen.Test.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ChenChen
 * @since 2021-10-16
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
