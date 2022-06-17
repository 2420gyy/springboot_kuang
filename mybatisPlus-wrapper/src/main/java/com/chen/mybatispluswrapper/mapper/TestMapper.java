package com.chen.mybatispluswrapper.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.mybatispluswrapper.entity.test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ChenChen
 * @since 2021-10-12
 */
@Mapper
public interface TestMapper extends BaseMapper<test> {

    int insertUser(test t);

    HashMap<String, String> selectPerson(Integer id);

    test selectByName(int i);

    test selectByIdAndName(@Param("id") Integer id,@Param("testName") String name);
}
