package com.restAPI.restAPI.controller;

import com.restAPI.restAPI.Entity.Employee;
import com.restAPI.restAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService service;

    @Autowired
    EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
     return service.getAllEmployees();
    }
}
