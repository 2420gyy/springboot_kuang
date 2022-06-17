package com.chen.work有时间整理回顾下.递归;


import java.util.ArrayList;
import java.util.List;

public class CatalogVO  {
    private String id;
    private String parentId;
    List<CatalogVO> chirldren = new ArrayList<>();

    public CatalogVO(String id, String parentId) {
        this.id = id;
        this.parentId = parentId;
    }

    public void setChirldren(List<CatalogVO> chirldren) {
        this.chirldren = chirldren;
    }

    public CatalogVO() {
    }

    public CatalogVO(String id, String parentId, List<CatalogVO> chirldren) {
        this.id = id;
        this.parentId = parentId;
        this.chirldren = chirldren;
    }

    public String getId() {
        return id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "CatalogVO{" +
                "id='" + id + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}
