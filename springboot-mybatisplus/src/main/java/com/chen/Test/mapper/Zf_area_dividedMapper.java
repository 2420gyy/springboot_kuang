package com.chen.Test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.Test.entity.Zf_area_divided;
import com.chen.Test.vo.ZfAreaDividedVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ChenChen
 * @since 2022-02-28
 */
@Mapper
public interface Zf_area_dividedMapper extends BaseMapper<Zf_area_divided> {

    List<ZfAreaDividedVO> selectAllProvincial();

    List<ZfAreaDividedVO> selectAllCity();

    List<ZfAreaDividedVO> selectAllDistrict();
}
