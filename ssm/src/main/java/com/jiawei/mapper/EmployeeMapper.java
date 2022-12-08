package com.jiawei.mapper;

import com.jiawei.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {
    List<Employee> getAllEmp();
}
