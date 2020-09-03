package com.example.demo.service;

import com.example.demo.bean.Employee;
import com.example.demo.mapper.EmployeeMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;


    @Cacheable(value = "emps")
    public Employee getEmployee(Integer id){
        Employee employee = employeeMapper.getByEmployeeId(id);
        return employee;
    }


    @CachePut(value = "emp",key = "#employee.id")
    public Employee updateEmployee(Employee employee) {
        int i = employeeMapper.updateEmployee(employee);
        return employee;
    }

    @CacheEvict(value = "emp",allEntries = true,beforeInvocation = true)
    public void deleteEmployee(Integer id){
        employeeMapper.deleteEmployee(id);
    }

}
