package com.spring.springboot.spring_springboot.dao;

import com.spring.springboot.spring_springboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

    public void saveEmpl(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
