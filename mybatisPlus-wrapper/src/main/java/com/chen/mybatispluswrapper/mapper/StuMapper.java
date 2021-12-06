package com.chen.mybatispluswrapper.mapper;

import com.chen.mybatispluswrapper.entity.Stu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author chenchen
 * @date 2021-11-11 0:36
 */
@Mapper
public interface StuMapper {

    Stu findStudentBySid(@Param("sid")int sid);

    @Select("select s.sid,s.sname,s.age,s.course,sc.* from stu s,stu_card sc where s.sid = sc.cid")
    List<Stu> getAllStu();
}
