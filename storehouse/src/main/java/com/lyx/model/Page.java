package com.lyx.model;


public class Page {
    private long lineCount;	//商品总数量
    private long pageSize;	//页面商品数量
    private long pageCount; //页面总数
    private long pageNow; //当前页面
    private long startCount; //起始条数
    private Integer state; //被查询的状态
    private TGoods goods; //条件
    private TUser user; //条件


    public Page(long lineCount, long pageSize, long pageNow , Integer state) {
        this.state = state;
        this.lineCount = lineCount;
        this.pageSize = pageSize;
        this.pageNow = pageNow;
        this.pageCount = lineCount  % pageSize == 0 ? lineCount / pageSize : (lineCount / pageSize) + 1;
        this.startCount = (pageNow-1) * pageSize;

    }
    
    public Page() {

    }
   
    public long getLineCount() {
        return lineCount;
    }

    public void setLineCount(long lineCount) {
        this.lineCount = lineCount;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public long getPageNow() {
        return pageNow;
    }

    public void setPageNow(long pageNow) {
        this.pageNow = pageNow;
    }

    public long getStartCount() {
        return startCount;
    }

    public void setStartCount(long startCount) {
        this.startCount = startCount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public TGoods getGoods() {
        return goods;
    }

    public void setGoods(TGoods goods) {
        this.goods = goods;
    }

    public TUser getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Page{" +
                "lineCount=" + lineCount +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", pageNow=" + pageNow +
                ", startCount=" + startCount +
                ", state=" + state +
                ", goods=" + goods +
                ", user=" + user +
                '}';
    }

    public void setUser(TUser user) {
        this.user = user;
    }
}
