package com.chen.mybatispluswrapper.query;

public class QueryObject {
    private Integer num;

    private Integer currentPage;
    private Integer pageSize;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "QueryObject{" +
                "num=" + num +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
