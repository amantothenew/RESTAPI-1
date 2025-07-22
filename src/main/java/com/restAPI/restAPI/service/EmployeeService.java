package com.restAPI.restAPI.service;

import com.restAPI.restAPI.Entity.Employee;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService {
    private static List<Employee> employees = new ArrayList<>();
    private static Integer employeeCounter = 0;

    static {
        employees.add(new Employee(++employeeCounter, "Aman Pal", 22));
        employees.add(new Employee(++employeeCounter, "Ravi Gupta", 21));
        employees.add(new Employee(++employeeCounter, "Utkarsh Pal", 22));
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}
