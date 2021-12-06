package com.chen.mybatispluswrapper.entity;

import lombok.Data;

/**
 * @author chenchen
 * @date 2021-11-11 0:33
 */
@Data
public class Stu {
    private int sid;
    private String sname;
    private int age;
    private String course;
    private StuCard sc;
}
