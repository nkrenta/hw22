package com.example.hw22mockito.service;

import com.example.hw22mockito.Employees;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

     private static Map<Integer, Employees> employees;

    public EmployeeService() {
        employees = new HashMap<>();
    }

    public void addEmployee(int id, Employees employee) {
        employees.put(id, employee);
    }

    public void removeEmployee(int id) {
        employees.remove(id);
    }

    public Employees findEmployee(int id) {
        return employees.get(id);
    }

    public List<Employees> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    public void addTestData() {
        employees.put(1, new Employees("Иван", "Иванов", 20000, "1"));
        employees.put(2, new Employees("Петр", "Петров", 45000, "2"));
        employees.put(3, new Employees("Полина", "Гумнова", 65000, "1"));
        employees.put(4, new Employees("Артем", "Егоров", 35000, "3"));
        employees.put(5, new Employees("Олег", "Шепелюк", 65000, "4"));
        employees.put(6, new Employees("Андрей", "Кузин", 65000, "5"));

    }
}
