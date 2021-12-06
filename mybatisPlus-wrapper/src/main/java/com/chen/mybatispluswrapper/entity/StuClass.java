package com.chen.mybatispluswrapper.entity;

import lombok.Data;

import java.util.List;

/**
 * @author chenchen
 * @date 2021-11-12 22:30
 */
@Data
public class StuClass {
    private Integer cid;
    private String cname;
    private Integer sum;
    private List<StuInfo> stuInfoList;
}
