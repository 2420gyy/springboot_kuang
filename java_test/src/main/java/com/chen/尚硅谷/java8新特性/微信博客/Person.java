package com.chen.尚硅谷.java8新特性.微信博客;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
class Person {
	private String name;  // 姓名
	private int salary; // 薪资
	private int age; // 年龄
	private String sex; //性别
	private String area;  // 地区

	public Person() {

	}
	public List<Person> getPersonList(){
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("Tom", 8900, 23,"male", "New York"));
		personList.add(new Person("Jack", 7000, 23,"male", "Washington"));
		personList.add(new Person("Lily", 7801, 25,"female", "Washington"));
		personList.add(new Person("Anni", 8200, 44,"female", "New York"));
		personList.add(new Person("Owen", 9500, 32,"male", "New York"));
		personList.add(new Person("Alisa", 7900, 44,"female", "New York"));
		return personList;
	}


	// 构造方法
	public Person(String name, int salary, int age,String sex,String area) {
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.sex = sex;
		this.area = area;
	}
}


