package com.example.hw22mockito.controller;

import com.example.hw22mockito.Employees;
import com.example.hw22mockito.exceptions.NothingInside;
import com.example.hw22mockito.service.DepartmentService;
import com.example.hw22mockito.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {

    public final DepartmentService departmentService;
    public final EmployeeService employeeService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
        this.employeeService = new EmployeeService();
    }

    @GetMapping
    public String hello() {
        employeeService.addTestData();
        return "Hello, User!";
    }

    @GetMapping(path = "/{departmentId}/employee")
    public Map<String, List<Employees>> getAllEmployeesByDepartment(@PathVariable(required = false) String departmentId) {
        employeeService.addTestData();
     if (departmentId == null) {
            return departmentService.getAllEmployeesByDepartments();
        }
        return departmentService.getAllEmployeeByDepartment(departmentId);
    }

    @GetMapping(path = "/{departmentId}/salary/{action}")
    public int getAllEmployeesByDepartmentAndAction(@PathVariable(required = false) String departmentId, @PathVariable(required = false) String action) {
        employeeService.addTestData();
        if (action == null) {
            throw new NothingInside("No action required!");
        } else if (action.equals("sum")) {
            return departmentService.getEmployeeSalarySumByDepartment(departmentId);
        } else if (action.equals("max")) {
            return departmentService.getEmployeeWithMaxSalaryByDepartment(departmentId);
        } else if (action.equals("min")) {
            return departmentService.getEmployeeWithMinSalaryByDepartment(departmentId);
        }
        throw new NothingInside("No usable action required!");
    }

}
