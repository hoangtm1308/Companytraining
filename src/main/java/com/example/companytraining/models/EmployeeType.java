package com.example.companytraining.models;


public enum EmployeeType {
    INTERN("Intern"), FRESHER("Fresher"), EXPERIENCE("Experience");
    private String empType;

    EmployeeType(String empType) {
        this.empType = empType;
    }

    @Override
    public String toString() {
        return empType;
    }
}
