package com.jiawei.spring.service.impl;

import com.jiawei.spring.dao.DepartmentDao;
import com.jiawei.spring.dao.impl.DepartmentDaoImpl;
import com.jiawei.spring.pojo.Department;
import com.jiawei.spring.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    @Qualifier("departmentDaoImpl")
    private DepartmentDao deptDao;

    @Override
    public void saveDepartment(Department dept) {
        System.out.println("This is saveDepartment Method in service level...");
        deptDao.insertDept(dept);
    }

}
