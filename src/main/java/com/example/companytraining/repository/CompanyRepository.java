package com.example.companytraining.repository;

import com.example.companytraining.models.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {
}
