package com.example.companytraining.controllers;

import com.example.companytraining.services.CatalogueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final CatalogueService catalogueService;

    public IndexController(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
    }

    @RequestMapping({"","/","index","index.html"})
    public String getIndexPage(Model model){
        model.addAttribute("index", catalogueService.findAll());

        return "index";
    }
}
