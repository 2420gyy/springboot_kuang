package com.chen.集合容器测试;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author chenchen
 * @date 2021-12-04 10:25
 */
public class BaseMapTest {
    // 1.map的基本操作
    // 2.map集合的输出
    @Test
    public void test1(){
        // https://www.jianshu.com/p/a17b4717a721
        //创建HashMap集合：
        Map<String,String> map = new HashMap<>();
        System.out.println("HashMap元素大小:"+map.size());

        //元素添加:
        map.put("hi","hello");
        map.put("my","hello");
        map.put("name","hello");
        map.put("is","hello");
        map.put("jiaboyan","hello");

        // 获取values
        Collection<String> values = map.values();
        values.forEach(System.out::println);

        //遍历1：获取key的Set集合
        Set<String> keySets = map.keySet();
        for (String keySet : keySets) {
            System.out.println("键:"+keySet+" 值:"+map.get(keySet));
        }
        //遍历2:得到Set集合迭代器
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            // 注意 iterator.next() 是 mapEntry ！！！
            Map.Entry<String, String> mapEntry = iterator.next();
            // mapEntry.getKey()
            // mapEntry.getValue()
        }
        //遍历3:转换成Set集合，增强for循环
        Set<Map.Entry<String, String>> entries1 = map.entrySet();
        for (Map.Entry<String, String> stringStringEntry : entries1) {
            System.out.println("键:"+stringStringEntry.getKey()+" 值:"+stringStringEntry.getValue());
        }

        //元素获取：通过key获取value
        String hi = map.get("hi");

        //元素替换：map没有提供直接set方法，而是使用新增来完成更新操作
        map.put("jiaboyan","helloworld");

        //元素删除：
        String value = map.remove("jiaboyan");
        //清空所有元素：
        map.clear();
        //hashMap是否包含某个key：
        boolean isContain = map.containsKey("hello");
        //hashMap是否为空：
        boolean isEmpty = map.isEmpty();
    }

    // 3.list转map，普通方式
    @Test
    public void test2(){
        List<User> userList = new ArrayList<>();
        User user1 = new User(1,"小明");
        User user2 = new User(2,"小李");
        User user3 = new User(3,"小张");
        User user4 = new User(4,"小赵");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        Map<Integer, User> map = new HashMap<>();
        for (User user : userList) {
            map.put(user.getId(),user);
        }
        // lombok 的toString和自己重写的toString不一样
        Set<Integer> keySets = map.keySet();
        for (Integer keySet : keySets) {
            System.out.println("键:"+keySet+" 值:"+map.get(keySet));
        }
    }
    // 4.list转map，使用stream
    @Test
    public void test4(){
        List<User> userList = new ArrayList<>();
        User user1 = new User(1,"小明");
        User user2 = new User(2,"小李");
        User user3 = new User(3,"小张");
        User user4 = new User(3,"小赵");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        // 这种方式 key相同会报错>>>
        // java.lang.IllegalStateException: Duplicate key User{id=3, name='小张'}
        try {
            Map<Integer, User> map = userList.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        }catch (IllegalStateException e){
            System.out.println("报错信息为: "+e);
        }
        System.out.println("1");
        // 指定一个覆盖规则 (old,new)->new; new是新值，old是旧值.就是新的替代旧的
        Map<Integer, User> map1 = userList.stream()
                .collect(Collectors.toMap(User::getId, a->a,(k1,k2)->k2));
        Set<Integer> keySets1 = map1.keySet();
        for (Integer keySet : keySets1) {
            System.out.println("键:"+keySet+" 值:"+map1.get(keySet));
        }
        System.out.println("2");
        // 保证map和list顺序一致。。。
        Map<Integer, User> map2 = userList.stream()
                .collect(Collectors.toMap(User::getId, Function.identity(), (k1, k2) -> k2));
        System.out.println("map2 "+map2);
        Set keySets2 = map2.keySet();
        for (Object keySet : keySets2) {
            System.out.println("键:"+keySet+" 值:"+map2.get(keySet));
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class User{
        private int id;
        private String name;

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }



}
