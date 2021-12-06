package com.chen.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
public class EmployeeController {

    @RequestMapping("/emps")
    public String list(Model model){

        return "emp/list";
    }


}
