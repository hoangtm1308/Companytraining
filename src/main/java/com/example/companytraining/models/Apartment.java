package com.example.companytraining.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "apartment")
public class Apartment extends BaseEntity {

    private String name;
    private String description;

    @ManyToOne
    private Company company;
}
