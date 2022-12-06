package com.jiawei.controller;

import com.jiawei.dao.DepartmentDao;
import com.jiawei.dao.EmployeeDao;
import com.jiawei.pojo.Department;
import com.jiawei.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/employees")
    public String getALlEmp(Map<String, Object> map) {
        Collection<Employee> employees = employeeDao.getAll();
        map.put("employees", employees);
        return "employee_list";
    }

    @GetMapping("/toAddEmp")
    public String toAddEmp(Map<String, Object> map) {
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("departments", departments);
        return "add_employee";
    }

    @PostMapping("/employees")
    public String addEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employees";
    }

    @DeleteMapping("/employees/{empId}")
    public String deleteEmp(@PathVariable Integer empId) {
        employeeDao.delete(empId);
        return "redirect:/employees";
    }

    @GetMapping("/toUpdateEmp/{empId}")
    public String updateEmp(@PathVariable Integer empId, Map<String, Object> map) {
        Employee employee = employeeDao.get(empId);
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("employee", employee);
        map.put("departments", departments);
        return "edit_employee";
    }

    @PutMapping("/employees")
    public String putEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employees";
    }
}
