package com.spring.springboot.spring_springboot.controller;

import com.spring.springboot.spring_springboot.entity.Employee;
import com.spring.springboot.spring_springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees()
    {
        List<Employee> allE = employeeService.getAllEmployees();
        return allE;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id)
    {
        Employee emp = employeeService.getEmployee(id);

        return emp;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        employeeService.saveEmpl(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        employeeService.saveEmpl(employee);//т.к. внутри saveOrUpdate
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
        Employee employee = employeeService.getEmployee(id);

        employeeService.deleteEmployee(id);
        return "Empl whit ID = " + id + " was deleted";
    }

}
