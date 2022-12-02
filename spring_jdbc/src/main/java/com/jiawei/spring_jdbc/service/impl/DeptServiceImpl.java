package com.jiawei.spring_jdbc.service.impl;

import com.jiawei.spring_jdbc.dao.DeptDao;
import com.jiawei.spring_jdbc.pojo.Department;
import com.jiawei.spring_jdbc.service.DeptService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("deptService")
public class DeptServiceImpl implements DeptService {
    private final DeptDao deptDao;

    public DeptServiceImpl(DeptDao deptDao) {
        this.deptDao = deptDao;
    }

    @Override
    public List<Department> getAllDept() {
        return deptDao.selectAllDept();
    }
}
