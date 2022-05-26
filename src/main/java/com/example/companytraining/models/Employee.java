package com.example.companytraining.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "employee")
public class Employee extends BaseEntity{
    private String name;
    private String tel;
    private LocalDate doB;

    @Enumerated(value = EnumType.STRING)
    private EmployeeType type;

    @Lob
    private Byte[] image;

    @ManyToOne
    private Apartment apartment;

    @ManyToOne
    private Company company;
}
