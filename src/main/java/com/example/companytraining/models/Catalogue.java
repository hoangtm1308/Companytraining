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

    public Catalogue(Long id, String name, String description, Set<Company> companies) {
        super(id);
        this.name = name;
        this.description = description;
        this.companies = companies;
    }

    public Catalogue(String name, String description, Set<Company> companies) {
        this.name = name;
        this.description = description;
        this.companies = companies;
    }

    public Catalogue(Long id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

}
