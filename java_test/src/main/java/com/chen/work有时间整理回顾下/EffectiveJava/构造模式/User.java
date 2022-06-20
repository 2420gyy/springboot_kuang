package com.chen.work有时间整理回顾下.EffectiveJava.构造模式;

public class User {

    // 必须字段
    private int id;

    private String name;
    private String sex;
    private String job;
    private String health;
    private String BMI;
    private int height;
    private int weight;

    public User() {
        super();
    }

    public User(int id, String name, String sex, String job, String health, String bMI, int height, int weight) {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.job = job;
        this.health = health;
        BMI = bMI;
        this.height = height;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getBMI() {
        return BMI;
    }

    public void setBMI(String bMI) {
        BMI = bMI;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", job=" + job + ", health=" + health + ", BMI="
                + BMI + ", height=" + height + ", weight=" + weight + "]";
    }

}