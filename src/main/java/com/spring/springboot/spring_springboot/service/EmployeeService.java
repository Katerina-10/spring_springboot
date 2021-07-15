package com.spring.springboot.spring_springboot.service;

import com.spring.springboot.spring_springboot.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveEmpl(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
