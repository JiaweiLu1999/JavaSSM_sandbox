package com.jiawei.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiawei.pojo.Employee;
import com.jiawei.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{pageNum}")
    public String getAllEmp(@PathVariable Integer pageNum, Map<String, Object> map) {
        int pageNumDefault = 1;
        if (pageNum != null) {
            pageNum = pageNumDefault;
        }

        PageHelper.startPage(pageNum, 2);
        List<Employee> employees = employeeService.getEmployees();
        PageInfo<Employee> pageInfo = new PageInfo<>(employees, 5);
        System.out.println(pageInfo);

        map.put("employees", employees);
        return "employee_list";
    }
}
