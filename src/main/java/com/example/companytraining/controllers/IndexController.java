package com.example.companytraining.controllers;

import com.example.companytraining.models.Catalogue;
import com.example.companytraining.services.CatalogueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final CatalogueService catalogueService;

    public IndexController(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
    }

    @RequestMapping({"","/","index","index.html"})
    public String getIndexPage(Model model){
        model.addAttribute("catalogues", catalogueService.findAll());
        return "index";
    }

    @GetMapping("/createupdatecatalogue")
    public String createCatalogueForm(Catalogue catalogue){
        return "createupdatecatalogue";
    }

    @PostMapping("/createupdatecatalogue")
    public String processCreateCatalogue(@Validated Catalogue catalogue, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "createupdatecatalogue";
        } else {
            catalogueService.save(catalogue);
            return "redirect:/index";
        }
    }

    @GetMapping("/catalogue/delete/{id}")
    public String deleteCatalogue(@PathVariable Long id, Model model){
        catalogueService.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/catalogue/update/{id}")
    public String updateCatalogue(@PathVariable Long id, Model model){
        Catalogue catalogue = catalogueService.findById(id);
        model.addAttribute("catalogue", catalogue);
        return "createupdatecatalogue";
    }

    @PostMapping("/catalogue/update/{id}")
    public String processupdateCatalogue(@PathVariable Long id, @Validated Catalogue catalogue, BindingResult result){
        if(result.hasErrors()){
            catalogue.setId(id);
            return "createupdatecatalogue";
        } else {
            catalogueService.save(catalogue);
            return "redirect:/index";
        }
    }
}
