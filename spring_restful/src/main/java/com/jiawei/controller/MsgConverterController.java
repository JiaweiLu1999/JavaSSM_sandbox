package com.jiawei.controller;

import com.jiawei.pojo.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MsgConverterController {

    private static final String SUCCESS = "success";

    @RequestMapping(value = "/testRequestBody", method = RequestMethod.POST)
    public String testRequestBody(@RequestBody String reqBody) {
        System.out.println(reqBody);
        return SUCCESS;
    }

    @RequestMapping(value = "/testHttpEntity", method = RequestMethod.POST)
    public String testHttpEntity(HttpEntity<String> entity) {
        System.out.println(entity.getBody());
        System.out.println(entity.getHeaders());
        return SUCCESS;
    }

    @RequestMapping(value = "/testResponseBody")
    @ResponseBody
    public String testResponseBody() {
        System.out.println("Test ResponseBody...");
        return "Hello";
    }

    @RequestMapping("/testJson")
    @ResponseBody
    public Employee testJson() {
        System.out.println("Test json...");
        int i = 1 / 0;
        return new Employee(1010, "lu", "jl5999@gmail.com", 100.0, null);
    }


}
