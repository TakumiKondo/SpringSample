package com.example.demo.trySample;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findOne(int id) {
        Map<String, Object> map = employeeRepository.findOne(id);

        Employee employee = new Employee();
        employee.setId((Integer) map.get("id"));
        employee.setName((String) map.get("name"));
        employee.setAge((Integer) map.get("age"));

        return employee;
    }
}
