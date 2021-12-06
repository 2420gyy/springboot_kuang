package com.chen.深拷贝与浅拷贝;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;

/**
 * @author chenchen
 * @date 2021-12-03 11:25
 */
public class CopyTest {
    // 构造函数
    @Test
    public void constructorCopy() {
        Address address = new Address("武汉","china");
        User user = new User("张三",address);

        User copyUser = new User(user.getName(), new Address(address.getCity(), address.getCountry()));

        user.getAddress().setCity("襄阳");

        System.out.println(user);

        System.out.println(copyUser);

        assertNotSame(user.getAddress().getCity(), copyUser.getAddress().getCity());

    }
    // 重载clone()方法
    @Test
    public void cloneCopy() throws CloneNotSupportedException{
        // super.clone()其实是浅拷贝，所以在重写User类的clone()方法时，address对象需要调用address.clone()重新赋值。
        Address address = new Address("杭州", "中国");
        User user = new User("大山", address);

        // 调用clone()方法进行深拷贝
        User copyUser = user.clone();

        // 修改源对象的值
        user.getAddress().setCity("深圳");

        // 检查两个对象的值不同
        assertNotSame(user.getAddress().getCity(), copyUser.getAddress().getCity());
    }

    // Jackson序列化
    @Test
    public void jacksonCopy() throws Exception{
        Address address = new Address("杭州", "中国");
        User user = new User("大山", address);

        // 使用Jackson序列化进行深拷贝
        ObjectMapper objectMapper = new ObjectMapper();
        User copyUser = objectMapper.readValue(objectMapper.writeValueAsString(user), User.class);

        // 修改源对象的值
        user.getAddress().setCity("深圳");

        // 检查两个对象的值不同
        assertNotSame(user.getAddress().getCity(), copyUser.getAddress().getCity());
    }

}
