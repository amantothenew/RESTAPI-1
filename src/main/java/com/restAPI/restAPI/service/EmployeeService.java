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

    public Employee getById(int id) {
        return employees.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Employee save(Employee employee){
        employee.setId(++employeeCounter);
        employees.add(employee);
        return employee;
    }

    public Employee deleteById(int id) {
        Employee employee = employees.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);

        if(employee==null){
            return null;
        }

        employees.remove(employee);
        return employee;
    }

    public Employee update(Employee e, int id) {
        Employee employeeToUpdate = employees.stream()
                .filter(emp->emp.getId()==id)
                .findFirst()
                .orElse(null);
        if(employeeToUpdate==null){
            return null;
        }

        int index = employees.indexOf(employeeToUpdate);
        e.setId(id);
        employees.set(index, e);
        return employees.get(index);
    }


}
