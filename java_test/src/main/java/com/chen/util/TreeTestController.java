package com.chen.util;

import com.chen.pojo.treeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenchen
 * @date 2022-02-25 15:13
 */
public class TreeTestController {
    public static void main(String[] args) {
        // 创建模拟数据
        treeNode treeNode = new treeNode();
        List<treeNode> treeNodeList = new ArrayList<>();
        treeNodeList.add(new treeNode(1,0));
        treeNodeList.add(new treeNode(2,1));
        treeNodeList.add(new treeNode(3,1));
        treeNodeList.add(new treeNode(4,2));
        treeNodeList.add(new treeNode(5,2));
        treeNodeList.add(new treeNode(6,3));
        treeNodeList.stream().forEach(System.out::println);

    }
}
