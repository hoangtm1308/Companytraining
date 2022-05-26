package com.example.companytraining.controllers;

import com.example.companytraining.services.EmployeeService;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
