package com.jiawei.dao;

import com.jiawei.pojo.Department;
import com.jiawei.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<>();

        employees.put(1001, new Employee(1001, "E-AA", "aa@gmail.com", 200.0, new Department(1, "D-AA")));
        employees.put(1002, new Employee(1002, "E-BB", "bb@gmail.com", 300.0, new Department(2, "D-BB")));
        employees.put(1003, new Employee(1003, "E-CC", "cc@gmail.com", 400.0, new Department(3, "D-CC")));
        employees.put(1004, new Employee(1004, "E-DD", "aa@gmail.com", 500.0, new Department(4, "D-DD")));
        employees.put(1005, new Employee(1005, "E-EE", "ee@gmail.com", 600.0, new Department(5, "D-EE")));
    }

    private static Integer initId = 1006;

    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }

        employee.setDept(departmentDao.getDepartment(employee.getDept().getDeptId()));
        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll() {
        return employees.values();
    }

    public Employee get(Integer id) {
        return employees.get(id);
    }

    public void delete(Integer id) {
        employees.remove(id);
    }
}
