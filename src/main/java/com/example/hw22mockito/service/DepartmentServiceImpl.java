package com.example.hw22mockito.service;

import com.example.hw22mockito.Employees;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

     private final EmployeeService employeeService;
    public DepartmentServiceImpl(EmployeeService employeeService) {this.employeeService = employeeService;}

    public int getEmployeeSalarySumByDepartment(String department) {
        List<Employees> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(employee -> employee.getDepartmentId().equals(department))
                .mapToInt(Employees::getSalary).sum();
    }

    public int getEmployeeSalarySumByDepartments(String department) {
        List<Employees> employees = employeeService.getAllEmployees();
        return employees.stream()
                .mapToInt(Employees::getSalary).sum();
    }

    public int getEmployeeWithMaxSalaryByDepartment(String department) {
        List<Employees> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(employee -> employee.getDepartmentId().equals(department))
                .max(Comparator.comparingInt(Employees::getSalary))
                .stream().mapToInt()
                .orElse(null);
    }

    public Employees getEmployeeWithMinSalaryByDepartment(String department) {
        List<Employees> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(employee -> employee.getDepartmentId().equals(department))
                .min(Comparator.comparingInt(Employees::getSalary))
                .orElse(null);
    }

    public Map<String, List<Employees>> getAllEmployeeByDepartment(String department) {
        List<Employees> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(employee -> employee.getDepartmentId().equals(department))
                .collect(Collectors.groupingBy(Employees::getDepartmentId));
    }

    public Map<String, List<Employees>> getAllEmployeesByDepartments() {
        List<Employees> employees = employeeService.getAllEmployees();
        return employees.stream()
                .collect(Collectors.groupingBy(Employees::getDepartmentId));

    }

}
