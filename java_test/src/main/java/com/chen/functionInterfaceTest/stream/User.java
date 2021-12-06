package com.chen.functionInterfaceTest.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenchen
 * @date 2021-12-01 23:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Comparable<User>{
    private int id;
    private String name;
    private int age;

    @Override
    public int compareTo(User o) {
        if(this.id>o.getId()){
            return 1;
        }else if(this.id<o.getId()){
            return -1;
        }
        return 0;
    }
}
