package com.jiawei.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Employee implements Serializable {

    private static final long serialVersionUID = -1646502553472109075L;
    private Integer id;
    private String lastName;
    private String email;
    private Double salary;
    private Department dept;

    public Employee() {
    }

    public Employee(Integer id, String lastName, String email, Double salary, Department dept) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}

