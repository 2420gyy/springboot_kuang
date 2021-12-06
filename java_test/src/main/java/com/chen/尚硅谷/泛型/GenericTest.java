package com.chen.尚硅谷.泛型;

/**
 * @author chenchen
 * @date 2021-12-05 13:19
 */

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 泛型的使用
 *  jdk1.5时引入
 *  实例化时可以指明泛型类型
 *  泛型类型必须是一个类
 *  3. 自定义泛型类，接口；泛型方法
 *
 *  子类继承父类时:
 *  子类不保留类型
 *  1）没有类型，擦除了，等价于 Object
 *  2）具体类型 指明父类T的具体类型
 *  子类保留类型
 *  1）全部保留
 *  2）部分保留，另一部分指定具体
 *
 */
public class GenericTest implements OrderInter<Integer>{

    // 在集合中使用泛型之前
    @Test
    public void test1(){
        ArrayList list = new ArrayList();

        list.add(78);
        list.add(79);
        list.add(80);
        list.add(81);
        // 问题一: 类型不安全
        list.add("tom");

        for(Object score:list){
            // 问题二: 强转时，出现ClassCastException
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }
    }
    // 在集合中使用泛型,ArrayList
    // 泛型不能是基本类型
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(78);
        list.add(79);
        list.add(80);
        list.add(81);
        // 编译时，就会进行类型检查
        // list.add("sss");
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    // 在集合中使用泛型,
    @Test
    public void test3(){
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("tom",93);
        hashMap.put("tom2",94);
        hashMap.put("tom3",95);
        hashMap.put("tom4",96);

        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey()+" :: "+entry.getValue());
        }
    }
    @Test
    public void test4(){
        // 此时为Object类型
        // Order order = new Order();
        // order.setOrderT("ss");
        Order<String> order = new Order<>();
        order.setOrderT("自定义泛型");
        order.setOrderId(1);
        order.setOrderName("小明");
        System.out.println(order);
    }
    @Test
    public void test5(){
        SubOrder subOrder = new SubOrder();
        // 子类在继承时指明了父类的泛型类型，则，实例化子类对象时，不再需要指明泛型
        subOrder.setOrderT(111);
        // 没有指明父类的泛型类型
        SubOrder1<String> subOrder1 = new SubOrder1<>();
        subOrder1.setOrderT("ss");

    }
    // 测试泛型方法
    @Test
    public void test6(){

        // 方法和类型是否可以声明static取绝于调用的时候类是否已经创建好，
        // 和类型是否明确，泛型参数在调用的时候明确了，不是在实例化的时候

        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        List<Integer> integers = order.copyFromArrayToList(arr);
        System.out.println(integers);
    }


    @Override
    public Integer getOneById() {
        return null;
    }
}
