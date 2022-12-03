package com.jiawei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/emp")
public class EmpController {
    private static final String SUCCESS = "success";
    private static final String EMP_INDEX = "employee";

    @RequestMapping({"/", ""})
    public String empIndex() {
        System.out.println("==> Load Emp Homepage...");
        return EMP_INDEX;
    }

    @RequestMapping("/saveEmp")
    public String saveEmp() {
        System.out.println("==> This is SaveEmp() method...");
        return SUCCESS;
    }

    @RequestMapping({"/testPathVar/{id}", "/testPathVar/"})
    public String testPathVar(@PathVariable(value = "id", required = false) Integer id) {
        System.out.println(id);
        return SUCCESS;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable String id) {
        System.out.println("==> Delete Emp " + id);
        return SUCCESS;
    }
}
