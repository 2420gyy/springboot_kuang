package com.chen.mybatispluswrapper.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ChenChen
 * @since 2021-10-12
 */
@ApiModel(value = "Student对象", description = "")
public class Student implements Serializable {


    private Integer id;

    private String name;

    private Integer tid;

    public Student() {
    }

    public Student(Integer id, String name, Integer tid) {
        this.id = id;
        this.name = name;
        this.tid = tid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tid=" + tid +
                '}';
    }
}
