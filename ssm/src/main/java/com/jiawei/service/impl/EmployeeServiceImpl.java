package com.jiawei.service.impl;

import com.jiawei.mapper.EmployeeMapper;
import com.jiawei.pojo.Employee;
import com.jiawei.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getEmployees() {
        return employeeMapper.getAllEmp();
    }
}
