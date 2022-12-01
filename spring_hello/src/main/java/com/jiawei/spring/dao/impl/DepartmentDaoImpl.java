package com.jiawei.spring.dao.impl;

import com.jiawei.spring.dao.DepartmentDao;
import com.jiawei.spring.pojo.Department;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
    @Override
    public void insertDept(Department dept) {
        System.out.println("This is insertDept method...");
    }
}
