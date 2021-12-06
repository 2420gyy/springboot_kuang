package com.chen.mybatispluswrapper.mapper;

import com.chen.mybatispluswrapper.entity.StuClass;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chenchen
 * @date 2021-11-12 23:40
 */
@Mapper
public interface StuClassMapper {

    StuClass findStuClassByCid(int cid);
}
