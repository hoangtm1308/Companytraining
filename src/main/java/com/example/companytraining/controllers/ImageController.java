package com.example.companytraining.controllers;

import com.example.companytraining.services.EmployeeService;
import com.example.companytraining.services.ImageService;

public class ImageController {
    private final ImageService imageService;
    private final EmployeeService employeeService;

    public ImageController(ImageService imageService, EmployeeService employeeService) {
        this.imageService = imageService;
        this.employeeService = employeeService;
    }
}
