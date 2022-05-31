package com.example.companytraining.controllers;

import com.example.companytraining.services.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping({"company/list","company"})
    public String getCompanyListByCatalogueId(Model model){
        model.addAttribute("companies",companyService.findAll());
        return "companies/companylist";
    }
}
