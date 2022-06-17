package com.chen.pojo;

import java.util.List;

/**
 * @author chenchen
 * @date 2022-02-25 15:11
 */
public class treeNode {
    private Integer id;
    private Integer parent_id;
    private List<treeNode> treeTestList;

    public treeNode(Integer id, Integer parent_id, List<treeNode> treeTestList) {
        this.id = id;
        this.parent_id = parent_id;
        this.treeTestList = treeTestList;
    }

    public treeNode() {
    }

    public treeNode(Integer id, Integer parent_id) {
        this.id = id;
        this.parent_id = parent_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public List<treeNode> getTreeTestList() {
        return treeTestList;
    }

    public void setTreeTestList(List<treeNode> treeTestList) {
        this.treeTestList = treeTestList;
    }

    @Override
    public String toString() {
        return "treeNode{" +
                "id=" + id +
                ", parent_id=" + parent_id +
                ", treeTestList=" + treeTestList +
                '}';
    }
}
