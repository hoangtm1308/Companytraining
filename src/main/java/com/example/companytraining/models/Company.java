package com.example.companytraining.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Company extends BaseEntity{
    private String name;
    private String address;
    private String tel;

    @ManyToMany
    @JoinTable(name = "company_catalogue", joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "catalogue_id"))
    private Set<Catalogue> catalogues = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private Set<Apartment> apartments = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private Set<Employee> employees = new HashSet<>();

}
