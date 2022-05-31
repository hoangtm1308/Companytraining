package com.example.companytraining.services.impl;

import com.example.companytraining.models.Catalogue;
import com.example.companytraining.repository.CatalogueRepository;
import com.example.companytraining.repository.CompanyRepository;
import com.example.companytraining.services.CatalogueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class CatalogueServiceImpl implements CatalogueService {

    private final CatalogueRepository catalogueRepository;
    private final CompanyRepository companyRepository;

    public CatalogueServiceImpl(CatalogueRepository catalogueRepository, CompanyRepository companyRepository) {
        this.catalogueRepository = catalogueRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public Set<Catalogue> findAll() {
        Set<Catalogue> catalogues = new HashSet<>();
        catalogueRepository.findAll().iterator().forEachRemaining(catalogues::add);
        return catalogues;
    }

    @Override
    public Catalogue findById(Long id) {
        Optional<Catalogue> catalogueOptional = catalogueRepository.findById(id);
        if(!catalogueOptional.isPresent()){
            throw new RuntimeException("Catalogue Not Found!");
        }
        return catalogueOptional.get();
    }

    @Override
    public Catalogue save(Catalogue catalogue) {
        if(catalogue.getName() == null || catalogue.getDescription() == null){
            return null;
        }
        if(catalogue.getName().isEmpty() || catalogue.getDescription().isEmpty()){
            return null;
        }
        return  catalogueRepository.save(catalogue);
    }

    @Override
    public void delete(Catalogue catalogue) {
        catalogueRepository.delete(catalogue);
    }

    @Override
    public void deleteById(Long id) {
        catalogueRepository.deleteById(id);
    }

}
