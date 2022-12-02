package com.jiawei.spring_jdbc.dao;

import com.jiawei.spring_jdbc.pojo.Department;

import java.util.List;

public interface DeptDao {
    public List<Department> selectAllDept();
}
