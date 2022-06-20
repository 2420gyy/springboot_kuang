package com.chen.work有时间整理回顾下.EffectiveJava.构造模式;

public class UserBuilder {

    private User user = new User();

    // 构造方法确保ID必有(!!!)
    public UserBuilder(int id) {
        user.setId(id);
    }

    // 实现流式写法(返回了this，即UserBuilder对象)
    UserBuilder name(String name) {
        user.setName(name);
        return this;
    }

    UserBuilder sex(String sex) {
        user.setSex(sex);
        return this;
    }

    UserBuilder job(String job) {
        user.setJob(job);
        return this;
    }

    UserBuilder health(String health) {
        user.setHealth(health);
        return this;
    }

    UserBuilder BMI(String BMI) {
        user.setBMI(BMI);
        return this;
    }

    UserBuilder height(int height) {
        user.setHeight(height);
        return this;
    }

    UserBuilder weight(int weight) {
        user.setWeight(weight);
        return this;
    }

    // 做判断，并最终返回User类型对象
    public User build() {
        if (user.getId() == 0) {
            throw new RuntimeException("id必须设置");
        }

        return user;
    }
}
