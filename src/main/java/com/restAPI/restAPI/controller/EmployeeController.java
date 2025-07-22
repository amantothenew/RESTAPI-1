package com.restAPI.restAPI.controller;

import com.restAPI.restAPI.Entity.Employee;
import com.restAPI.restAPI.exception.EmployeeNotFoundException;
import com.restAPI.restAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService service;

    @Autowired
    EmployeeController(EmployeeService service) {
        this.service = service;
    }

    //to get all users
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
     return service.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getAllEmployees(@PathVariable int id) {
        if(service.getById(id)==null){
            throw new EmployeeNotFoundException("Employee not found");
        }
        return service.getById(id);
    }

    @PostMapping("/employees")
    public ResponseEntity<Void> getAllEmployees(@RequestBody Employee employee) {
        Employee save = service.save(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(save.getId())
                        .toUri();

        return ResponseEntity.created(location).build();
    }

}
