package com.jiawei.spring.factory;

import com.jiawei.spring.pojo.Department;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Department> {
    @Override
    public Department getObject() throws Exception {
        return new Department(101, "c++", null);
    }

    @Override
    public Class<?> getObjectType() {
        return Department.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
