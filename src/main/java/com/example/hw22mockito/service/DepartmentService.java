package com.example.hw22mockito.service;

import com.example.hw22mockito.Employees;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Map<String, List<Employees>> getAllEmployeesByDepartments();

    Map<String, List<Employees>> getAllEmployeeByDepartment(String departmentId);

    int getEmployeeSalarySumByDepartment(String departmentId);
    
    int getEmployeeWithMaxSalaryByDepartment(String departmentId);

    int getEmployeeWithMinSalaryByDepartment(String departmentId);
}
