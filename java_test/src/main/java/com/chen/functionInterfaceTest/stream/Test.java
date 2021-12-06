package com.chen.functionInterfaceTest.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenchen
 * @date 2021-12-01 23:50
 */
// id 偶数 age>23 name big sort(false) 取一个用户
public class Test {
    public static void main(String[] args) {
        User u1 = new User(1, "a", 21);
        User u2 = new User(2, "b", 22);
        User u3 = new User(3, "c", 23);
        User u4 = new User(4, "d", 24);
        User u5 = new User(5, "e", 25);

        List<User> userStream = new ArrayList<>();
        userStream.add(u1);
        userStream.add(u2);
        userStream.add(u3);
        userStream.add(u4);
        userStream.add(u5);
        userStream.stream().filter(user -> user.getId()%2==0)
                .filter(user -> user.getAge()>21)
                .map(user -> {user.getName().toUpperCase();return user;})
                .sorted((k1,k2) -> k2.compareTo(k1))
                // .limit(1)
                .forEach(System.out::println);

    }
}
