package com.jiawei.mybatis.mapper;

import com.jiawei.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    Employee selectEmployeeById(int id);

    void insertEmployee(Employee employee);

    void deleteEmployeeById(int id);

    int updateEmployee(Employee employee);

    List<Employee> selectAllEmployee();

    @MapKey("id")
    Map<Integer, Employee> selectAllEmployeeToMap();

    Employee selectEmployeeAndDeptById(int id);

    Employee selectEmployeeAndDeptByIdStep(int id);

    List<Employee> selectEmpByDeptId(int deptId);
}
