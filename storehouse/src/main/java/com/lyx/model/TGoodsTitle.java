package com.lyx.model;

public class TGoodsTitle {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_title.id
     *
     * @mbg.generated Wed Nov 11 20:16:19 GMT+08:00 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_title.title
     *
     * @mbg.generated Wed Nov 11 20:16:19 GMT+08:00 2020
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_title.title_name
     *
     * @mbg.generated Wed Nov 11 20:16:19 GMT+08:00 2020
     */
    private String titleName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_title.id
     *
     * @return the value of t_goods_title.id
     *
     * @mbg.generated Wed Nov 11 20:16:19 GMT+08:00 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_title.id
     *
     * @param id the value for t_goods_title.id
     *
     * @mbg.generated Wed Nov 11 20:16:19 GMT+08:00 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_title.title
     *
     * @return the value of t_goods_title.title
     *
     * @mbg.generated Wed Nov 11 20:16:19 GMT+08:00 2020
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_title.title
     *
     * @param title the value for t_goods_title.title
     *
     * @mbg.generated Wed Nov 11 20:16:19 GMT+08:00 2020
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_title.title_name
     *
     * @return the value of t_goods_title.title_name
     *
     * @mbg.generated Wed Nov 11 20:16:19 GMT+08:00 2020
     */
    public String getTitleName() {
        return titleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_title.title_name
     *
     * @param titleName the value for t_goods_title.title_name
     *
     * @mbg.generated Wed Nov 11 20:16:19 GMT+08:00 2020
     */
    public void setTitleName(String titleName) {
        this.titleName = titleName == null ? null : titleName.trim();
    }

    @Override
    public String toString() {
        return "TGoodsTitle{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", titleName='" + titleName + '\'' +
                '}';
    }
}