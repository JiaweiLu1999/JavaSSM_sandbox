package com.jiawei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/testRequestParam")
public class TestRequestParam {
    private static final String SUCCESS = "success";

    @RequestMapping("")
    public String requestParam(@RequestParam String name, Integer age) {
        System.out.println(name);
        System.out.println(age);
        return SUCCESS;
    }

}
