package com.example.companytraining.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "catalogue")
public class Catalogue extends BaseEntity{
    private String name;
    private String description;

    @ManyToMany(mappedBy = "catalogues")
    private Set<Company> companies;
}
