package com.chen.深拷贝与浅拷贝;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Cloneable{
 
    private String name;
    private Address address;

    // constructors, getters and setters

    @Override
    public User clone() throws CloneNotSupportedException {
        User user = (User) super.clone();
        user.setAddress(this.address.clone());
        return user;
    }
}