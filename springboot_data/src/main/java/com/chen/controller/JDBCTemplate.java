package com.chen.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCTemplate {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询数据库的所有信息
    @GetMapping("/userList")
    public List<Map<String,Object>> userList(){
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }
    @GetMapping("/addUser")
    public String addUser(){
        String sql = "insert into mybatis.user(id,name,pwd,age) values (10,'zhansan','1234',12)";
        jdbcTemplate.update(sql);
        return "update-ok";
    }




    //toDelete?id=${emp.id}
    //deleteUser?id=10
    @GetMapping("/deleteUser")
    public String deleteUser(int id){
        String sql = "delete from mybatis.user where id = ?";
        jdbcTemplate.update(sql,id);
        return "delete-ok1";
    }
//前端跳转参考
//<a href="${pageContext.request.contextPath}/emp/toDelete?id=${emp.id}">delete</a>
    //toDelete/${emp.id}
    //updateUser/3
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql = "update mybatis.user set name=?,pwd=?  where id = "+id;
        //封装
        Object[] objects = new Object[2];
        objects[0] = "xiao1";
        objects[1] = "12345";

        jdbcTemplate.update(sql,objects);
        return "update-ok2";
    }
}
