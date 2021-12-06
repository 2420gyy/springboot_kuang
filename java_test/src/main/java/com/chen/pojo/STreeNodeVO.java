package com.chen.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author chenchen
 * @date 2021-11-21 16:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class STreeNodeVO {

    @ApiModelProperty(value = "主键id")
    private String nodeid;

    @ApiModelProperty(value = "节点名称")
    private String nodename;

    @ApiModelProperty(value = "上级节点ID")
    private String parentid;

    private List<STreeNodeVO> sTreeNodeVOList;
}
