package com.jiawei.spring_jdbc.dao.impl;

import com.jiawei.spring_jdbc.dao.DeptDao;
import com.jiawei.spring_jdbc.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("deptDao")
public class DeptDaoImpl implements DeptDao {
    private final JdbcTemplate jdbcTemplate;

    public DeptDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Department> selectAllDept() {
        String sql = "select * from department";
        BeanPropertyRowMapper<Department> rowMapper = new BeanPropertyRowMapper<>(Department.class);
        return jdbcTemplate.query(sql, rowMapper);
    }
}