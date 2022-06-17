package com.chen.Test.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author chenchen
 * @date 2022-02-28 22:02
 */
@Data
public class ZfAreaDividedVO {
    @ApiModelProperty(value = "数据唯一标志id")
    private String id;

    @ApiModelProperty(value = "行政区划代码")
    private String adminDivisionCode;

    @ApiModelProperty(value = "区划名称")
    private String adminDivisionName;

    @ApiModelProperty(value = "层级代码")
    private String levelCode;

    @ApiModelProperty(value = "父级行政区划代码")
    private String parentCode;

    @ApiModelProperty(value = "父级行政区划名称")
    private String parentName;

    @ApiModelProperty(value = "子级行政区")
    private List<ZfAreaDividedVO> zfAreaDividedVOList;
}
