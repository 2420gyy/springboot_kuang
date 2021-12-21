package com.chen.jsonTest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value="处罚执法人员传参对象", description="处罚执法人员传参对象")
public class ZfPunishStaffBO implements Serializable {

    @ApiModelProperty(value = "执法人员ID-UUID")
    private String id;

    @ApiModelProperty(value = "执法人员ID-personId")
    private String personId;

    @ApiModelProperty(value = "执法人员姓名")
    private String personName;

    @ApiModelProperty(value = "执法人员编号")
    private String personCode;

    // @ApiModelProperty(value = "执法人员类型")
    // private String personType;

}
