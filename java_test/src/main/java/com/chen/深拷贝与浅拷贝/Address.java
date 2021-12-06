package com.chen.深拷贝与浅拷贝;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 地址
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Cloneable{
 
    private String city;
    private String country;

    // constructors, getters and setters

    @Override
    public Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }
}