package com.jiawei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    private static final String INDEX = "index";
    private static final String SUCCESS = "success";

    @RequestMapping("/")
    public String toIndex() {
        return INDEX;
    }

    @RequestMapping("/HelloController/*")
    public String helloWorld() {
        System.out.println("==> HelloController!");
        return SUCCESS;
    }


}
