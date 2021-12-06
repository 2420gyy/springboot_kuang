package com.chen.mybatispluswrapper.entity;

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
@ApiModel(value = "Teacher对象", description = "")
public class Teacher implements Serializable {


    private Integer id;

    private String name;


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

    @Override
    public String toString() {
        return "Teacher{" +
        "id=" + id +
        ", name=" + name +
        "}";
    }
}
