package com.chen.尚硅谷.java8新特性.微信博客;

import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chenchen
 * @date 2022-01-14 15:45
 */
public class Test2 {
    @Test
    public void test1(){
        /**
         * Optional类是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
         */
        /**
         * 遍历/匹配（foreach/find/match）
         */
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        // 遍历输出符合条件的元素
        list.stream().filter((x)->x>3).forEach(System.out::println);
        System.out.println("========");
        // 匹配第一个
        Integer integer = list.stream().filter((x) -> x > 3).findFirst().get();
        System.out.println(integer);
        System.out.println("========");
        // 匹配任意 findAny 适用于并行流
        Integer integer1 = list.parallelStream().filter((x) -> x > 3).findAny().get();
        System.out.println(integer1);
        // 是否包含符合特定条件的元素
        // allMatch 所有都匹配 / anyMatch 任意一个匹配
        boolean b = list.stream().allMatch(x->x>6);
        System.out.println("输出: "+b);
    }
    @Test
    public void test2(){
        /**
         * filter
         * 筛选，是按照一定的规则校验流中的元素，将符合条件的元素提取到新的流中的操作。
         */
        // 案例一：筛选出Integer集合中大于7的元素，并打印出来
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        List<Integer> collect = list.stream().filter(x -> x > 5).collect(Collectors.toList());
        for (Integer integer : collect) {
            System.out.print(integer+" ");
        }
        System.out.println("======");
        // 案例二： 筛选员工中工资高于8000的人，并形成新的集合。 形成新集合依赖collect（收集）
        Person person = new Person();
        List<Person> personList = person.getPersonList();
        // Function<T,R> 接收一个参数并返回结果的函数
        List<String> collect1 = personList.stream()
                .filter(person1 -> person1.getSalary() > 8000 ).map(x->x.getName()).collect(Collectors.toList());
        collect1.stream().forEach(System.out::println);
    }
    @Test
    public void test3(){
        /*
        聚合（max/min/count)
         */
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        // 案例一：获取String集合中最长的元素。
        // String s = list.stream().max(Comparator.comparing(n->n.length())).get();
        String s = list.stream().max(Comparator.comparing(String::length)).get();
        System.out.println(s);

        System.out.println("======");
        // 案例二：获取Integer集合中的最大值。
        List<Integer> list1 = Arrays.asList(7, 6, 9, 4, 11, 6);
        Integer integer = list1.stream().max(Integer::compareTo).get();
        // Integer integer2 = list1.stream().max((o1, o2) -> o1.compareTo(o2)).get();
        // Integer integer2 = list1.stream().max(Comparator.naturalOrder()).get();
        Integer integer2 = list1.stream().max(Comparator.comparing(Integer::intValue)).get();
        System.out.println(integer);
        System.out.println(integer2);

        // 案例三：获取员工工资最高的人。
        List<Person> personList = new Person().getPersonList();
        String s1 = personList.stream().max(Comparator.comparing(x -> x.getSalary())).map(x -> x.getName()).get();
        System.out.println(s1);

        // 案例四：计算Integer集合中大于6的元素的个数。
        // int size = list1.stream().filter(x -> x > 6).collect(Collectors.toList()).size();
        long size = list1.stream().filter(x -> x > 6).count();
        System.out.println(size);
    }
    //  映射(map/flatMap)
    // map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
    // flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
    @Test
    public void test4(){
        // 案例一：英文字符串数组的元素全部改为大写。整数数组每个元素+3。
        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
        List<String> collect4 = Arrays.stream(strArr).peek(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.toUpperCase());
            }
        }).collect(Collectors.toList());
        System.out.println("------");
        List<String> collect = Arrays.stream(strArr).map(x -> x.toUpperCase()).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println("======");
        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> collect1 = intList.stream().map(x -> x + 3).collect(Collectors.toList());
        System.out.println(collect1);
        System.out.println("======");
        // 案例二：将员工的薪资全部增加1000。
        List<Person> personList = new Person().getPersonList();
        List<Integer> collect2 = personList.stream().filter(x->x.getSalary()<6000).map(x -> x.getSalary() + 1000).collect(Collectors.toList());
        System.out.println("-=-=-=-=-=-=-=--");
        // 案例三：将两个字符数组合并成一个新的字符数组。
        // 将元素拆开返回
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> collect3 = list.stream().flatMap(s -> {
            String[] split = s.split(",");
            // 将每一个元素转为一个stream
            Stream<String> stream = Arrays.stream(split);
            return stream;
        }).collect(Collectors.toList());
        System.out.println(collect3);
    }
    @Test
    public void test5(){
        // 归约(reduce) 把一个流缩减成一个值，能实现对集合求和、求乘积和求最值操作
        // 案例一：求Integer集合的元素之和、乘积和最大值。
        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
        // 参数1 初始值;
        Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);
        Integer integer = list.stream().reduce(Integer::sum).get();

        Integer reduce1 = list.stream().reduce(0, (x, y) -> x * y);
        System.out.println(reduce1);
        Integer reduce2 = list.stream().reduce(0, (x, y) ->x>y?x:y);
        System.out.println(reduce2);
        Integer reduce3 = list.stream().reduce(1, Integer::max);
        System.out.println(reduce3);


        // 求所有员工的工资之和和最高工资。
        List<Person> personList = new Person().getPersonList();
        System.out.println("------------");
        // 1.不会
        Integer max = personList.stream().map(x -> x.getSalary()).max(Integer::compareTo).get();
        Integer integer1 = personList.stream().map(Person::getSalary).max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        }).get();
        // 这个不理解。。。
        Integer integer2 = personList.stream().map(Person::getSalary).max((o1, o2) -> o1 > o2 ? o1 : (o1 = o2)).get();
        System.out.println("integer1 "+integer1);
        System.out.println("integer2 "+integer2);
        System.out.println("max "+max);
        System.out.println("------------");
        Integer reduce4 = personList.stream().map(x -> x.getSalary()).reduce(0, (x, y) -> x + y);
        Optional<Integer> reduce5 = personList.stream().map(Person::getSalary).reduce(Integer::max);
        System.out.println(reduce5.get());

        System.out.println("======");
    }
    @Test
    public void test6(){

        Map<String, String> map = new HashMap<>();
        map.put("北京","天气晴1");
        map.put("上海","天气晴2");
        map.put("广州","天气晴3");
        map.put("武汉","天气晴4");

        String ss = map.get("ss");
        Set<String> keySet = map.keySet();
        System.out.println(keySet);

        System.out.println(ss);
    }
    @Test
    public void test7(){
        // Supplier 生产接口
        // Consumer 消费接口

        List<Person> personList = new Person().getPersonList();
        System.out.println(personList);
        System.out.println("=====");
        List<Person> collect = personList.stream().peek(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person.getSalary() + 1);
            }
        }).collect(Collectors.toList());
        // System.out.println(collect);
    }
    @Test
    public void test8(){
        /*
        计数：count
        平均值：averagingInt、averagingLong、averagingDouble
        最值：maxBy、minBy
        求和：summingInt、summingLong、summingDouble
        统计以上所有：summarizingInt、summarizingLong、summarizingDouble
         */
        /*
        案例：统计员工人数、平均工资、工资总额、最高工资。
         */
        List<Person> personList = new Person().getPersonList();
        long count = personList.stream().count();
        long l = personList.stream().collect(Collectors.counting()).longValue();
        System.out.println(count);
        System.out.println(l);
        System.out.println("====");
        Double collect = personList.stream().collect(Collectors.averagingInt(Person::getSalary));
        System.out.println(collect);
        Integer integer = personList.stream().map(Person::getSalary).reduce((x, y) -> x += y).get();
        System.out.println(integer);
        Person person = personList.stream().collect(Collectors.maxBy(Comparator.comparing(x -> x.getSalary()))).get();
        Integer integer1 = personList.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compare)).get();
        System.out.println(person);
        System.out.println(integer1);
        System.out.println("==这个方法。。。。一次统计所有的信息==");
        long sum = personList.stream().collect(Collectors.summarizingInt(Person::getSalary)).getSum();
        double average = personList.stream().collect(Collectors.summarizingInt(Person::getSalary)).getAverage();
        int max = personList.stream().collect(Collectors.summarizingInt(Person::getSalary)).getMax();
        long count1 = personList.stream().collect(Collectors.summarizingInt(Person::getSalary)).getCount();
        System.out.println("==="+sum+"==="+average+"==="+max+"==="+count1);
        System.out.println("======");
    }
    @Test
    public void test9(){
        // 分组:
        // 分区：将stream按条件分为两个Map，比如员工按薪资是否高于8000分为两部分。
        // 分组：将集合分为多个Map，比如员工按性别分组。有单级分组和多级分组。

        List<Person> personList = new Person().getPersonList();
        // 将员工按薪资是否高于8000分组
        Map<Boolean, List<Person>> collect = personList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));
        System.out.println(collect.get(true));
        // 将员工先按性别分组，再按地区分组
        Map<String, Map<String, List<Person>>> collect1 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));
        // java对象转json
        System.out.println(JSONUtil.toJsonStr(collect1));
        // 同时按sex和age分组 定义实体装进去。。。
        Map<String, List<Person>> collect2 = personList.stream().collect(Collectors.groupingBy(type -> type.getArea() + "_" + type.getSex()));
        System.out.println(JSONUtil.toJsonStr(collect2));
        System.out.println("======");
    }
    @Test
    public void test10(){
        List<Person> personList = new Person().getPersonList();
        String names = personList.stream().map(p -> p.getName()).collect(Collectors.joining(","));
        System.out.println("所有员工的姓名：" + names);
        List<String> list = Arrays.asList("A", "B", "C");
        String string = list.stream().collect(Collectors.joining("-"));
        System.out.println("拼接后的字符串：" + string);

        System.out.println("======");
    }
    @Test
    public void test11(){
        // 增加了自定义规约的支持
        List<Person> personList = new Person().getPersonList();
        // 每个员工减去起征点后的薪资之和（这个例子并不严谨，但一时没想到好的例子）
        Integer sum = personList.stream().collect(Collectors.reducing(0, Person::getSalary, (i, j) -> (i + j - 5000)));
        System.out.println("员工扣税薪资总和：" + sum);

        // stream的reduce
        Optional<Integer> sum2 = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println("员工薪资总和：" + sum2.get());

        System.out.println("======");
    }
    @Test
    public void test12(){
        // sorted()：自然排序，流中元素需实现Comparable接口
        // sorted(Comparator com)：Comparator排序器自定义排序
        List<Person> personList = new Person().getPersonList();
        // 按工资升序排序（自然排序）
        List<Person> collect = personList.stream().sorted(Comparator.comparing(Person::getSalary)).collect(Collectors.toList());
        System.out.println(collect);

        // 按工资倒序排序
        List<Person> collect1 = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed()).collect(Collectors.toList());
        System.out.println(collect1);

        // 先按工资再按年龄升序排序
        List<Person> collect2 = personList.stream().sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge)).collect(Collectors.toList());
        System.out.println(collect2);
        // 先按工资再按年龄自定义排序（降序）
        List<String> collect3 = personList.stream().sorted((p1, p2) -> {
            if (p1.getSalary() == p2.getSalary()) {
                return p2.getAge() - p1.getAge();
            } else {
                return p2.getSalary() - p1.getSalary();
            }
        }).map(Person::getName).collect(Collectors.toList());

    }
    @Test
    public void test13(){
        // 流也可以进行合并、去重、限制、跳过等操作。
        String[] arr1 = { "a", "b", "c", "d" };
        String[] arr2 = { "d", "e", "f", "g" };

        Stream<String> stream1 = Stream.of(arr1);
        Stream<String> stream2 = Stream.of(arr2);
        // concat:合并两个流 distinct：去重
        List<String> newList = Stream.concat(stream1, stream2).distinct().collect(Collectors.toList());
        // limit：限制从流中获得前n个数据 seed 初始值
        List<Integer> collect = Stream.iterate(3, x -> x + 2).limit(10).collect(Collectors.toList());
        // skip：跳过前n个数据
        List<Integer> collect2 = Stream.iterate(1, x -> x + 2).skip(1).limit(5).collect(Collectors.toList());

        System.out.println("流合并：" + newList);
        System.out.println("limit：" + collect);
        System.out.println("skip：" + collect2);


        System.out.println("======");
    }
    @Test
    public void test14(){
        // 模块名称
        System.out.println(System.getProperty("user.dir"));
        System.out.println(File.separator);
        System.out.println("======");
        // ThreadPoolExecutor threadPoolExecutor =
        //         new ThreadPoolExecutor(5,20,200,SECONDS,);
    }
}






















