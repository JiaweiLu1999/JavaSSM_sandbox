package com.jiawei.mybatis.mapper;

import com.jiawei.mybatis.pojo.Department;

public interface DepartmentMapper {
    Department selectDeptById(int deptId);

    Department selectDeptAndEmpByDeptId(int deptId);
}
