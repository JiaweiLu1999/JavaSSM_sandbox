package com.jiawei.mybatis.mapper;

import com.jiawei.mybatis.pojo.Employee;

public interface EmployeeMapper {
    Employee selectEmployeeById(int id);
}
