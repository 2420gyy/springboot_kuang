package com.chen.mybatispluswrapper.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.mybatispluswrapper.entity.Teacher;
import com.chen.mybatispluswrapper.vo.TeacherVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
public interface TeacherMapper extends BaseMapper<Teacher> {

    Teacher test(@Param("tid") int tid, String tName);

    List<TeacherVO> test2(String sName, Teacher teacher1);

    Teacher test1(String li, String laoshi);

    Teacher test0(Integer tId);
}
