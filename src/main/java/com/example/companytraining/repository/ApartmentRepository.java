package com.example.companytraining.repository;

import com.example.companytraining.models.Apartment;
import org.springframework.data.repository.CrudRepository;

public interface ApartmentRepository extends CrudRepository<Apartment, Long> {
}
