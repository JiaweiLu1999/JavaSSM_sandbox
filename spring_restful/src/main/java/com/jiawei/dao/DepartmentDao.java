package com.jiawei.dao;

import com.jiawei.pojo.Department;
import com.jiawei.pojo.Employee;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class DepartmentDao {
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<>();

        departments.put(1, new Department(1, "D-AA"));
        departments.put(2, new Department(2, "D-BB"));
        departments.put(3, new Department(3, "D-CC"));
        departments.put(4, new Department(4, "D-DD"));
        departments.put(5, new Department(5, "D-EE"));
    }

    public Collection<Department> getDepartments() {
        return departments.values();
    }


    public Department getDepartment(Integer deptId) {
        return departments.get(deptId);
    }
}
