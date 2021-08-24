package com.goIt.ProductManagement.controller;

import com.goIt.ProductManagement.model.dto.ManufacturerDTO;
import com.goIt.ProductManagement.model.service.ManufacturerService;
import com.goIt.ProductManagement.model.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Set;
import java.util.UUID;

@Controller
@RequestMapping(path = "manufacturer")
public class ManufacturerController {
    private static final Logger LOG = LoggerFactory.getLogger(ManufacturerController.class);
    private final ManufacturerService manufacturerService;
    private final ProductService productService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService, ProductService productService) {
        this.manufacturerService = manufacturerService;
        this.productService = productService;
    }

    @GetMapping("index")
    public String showProductIndexPage(Model model) {
        LOG.info("showManufacturersPage.");
        Set<ManufacturerDTO> manufacturers = manufacturerService.findAll();
        model.addAttribute("manufacturers", manufacturers);
        return "manufacturers";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("new")
    public String ShowNewManufacturerPage(Model model) {
        LOG.info("ShowNewManufacturerPage");
        ManufacturerDTO manufacturerDTO = new ManufacturerDTO();
        model.addAttribute("manufacturer", manufacturerDTO);
        return "manufacturerNew";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("update")
    public String ShowUpdateManufacturerPage(@RequestParam(name = "id") UUID id, Model model) {
        LOG.info("ShowUpdateManufacturerPage");
        ManufacturerDTO manufacturer = manufacturerService.findById(id);
        model.addAttribute("manufacturer", manufacturer);
        return "manufacturerUpdate";
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public RedirectView save(@ModelAttribute("manufacturer") ManufacturerDTO manufacturer) {
        manufacturerService.save(manufacturer);
        return new RedirectView("index");
    }

    @ModelAttribute("ManufacturerForm")
    public ManufacturerDTO defaultManufacturerDTO() {
        return new ManufacturerDTO();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/delete")
    public RedirectView delete(@RequestParam(name = "id") UUID id) {
        manufacturerService.delete(id);
        return new RedirectView("index");
    }

    @GetMapping(path = "/details")
    public String ShowDetailsManufacturerPage(@RequestParam(name = "id") UUID id, Model model) {
        LOG.info("ShowManufacturerDetailsPage");
        ManufacturerDTO manufacturer = manufacturerService.findById(id);
        model.addAttribute("manufacturer", manufacturer);
        return "manufacturerDetails";
    }
}
