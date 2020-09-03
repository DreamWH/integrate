package com.example.demo.controller;

import com.example.demo.bean.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id){
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }

    @PostMapping("/update")
    public Employee updateEmployee(@RequestBody  Employee employee){
        return employeeService.updateEmployee(employee);
    }
}
